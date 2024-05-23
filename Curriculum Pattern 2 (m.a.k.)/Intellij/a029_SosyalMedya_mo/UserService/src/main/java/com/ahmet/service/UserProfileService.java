package com.ahmet.service;

import com.ahmet.dto.request.NewCreateUserRequestDto;
import com.ahmet.dto.request.UpdateEmailOrUsernameRequestDto;
import com.ahmet.dto.request.UserProfileUpdateRequestDto;
import com.ahmet.exception.ErrorType;
import com.ahmet.exception.UserManagerException;
import com.ahmet.manager.IAuthManager;
import com.ahmet.mapper.IUserMapper;
import com.ahmet.rabbitmq.model.RegisterModel;
import com.ahmet.rabbitmq.producer.RegisterProducer;
import com.ahmet.repository.IUserProfileRepository;
import com.ahmet.repository.entity.UserProfile;
import com.ahmet.repository.enums.EStatus;
import com.ahmet.utility.JwtTokenManager;
import com.ahmet.utility.ServiceManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/** UserMikroServis'te findByRole diye bir metot yazalım. Bu metot
 * girdiğimiz role göre bize database'deki userProfile'ları dönsün.
 * Ayrıca bu metodu cache'leyelim. Bir de bu cache ne zaman ve
 * nasıl silinir, bununla ilgili kodları da yazın.
 */

@Service
public class UserProfileService extends ServiceManager<UserProfile,String> {

    private final IUserProfileRepository userProfileRepository;
    private final JwtTokenManager jwtTokenManager;
    private final IAuthManager authManager;
    private final CacheManager cacheManager;
    private final RegisterProducer registerProducer;

    public UserProfileService(IUserProfileRepository userProfileRepository, JwtTokenManager jwtTokenManager, IAuthManager authManager, CacheManager cacheManager, RegisterProducer registerProducer) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
        this.jwtTokenManager = jwtTokenManager;
        this.authManager = authManager;
        this.cacheManager = cacheManager;
        this.registerProducer = registerProducer;
    }



    public Boolean createUser(NewCreateUserRequestDto dto) {
        try {
            save(IUserMapper.INSTANCE.toUserProfile(dto));
            return true;
        }catch(Exception e) {
            throw new UserManagerException(ErrorType.USER_NOT_CREATED);
        }
    }

    public Boolean createUserWithRabbitMq(RegisterModel model) {
        try {
            UserProfile userProfile = save(IUserMapper.INSTANCE.toUserProfile(model));
            registerProducer.sendNewUser(IUserMapper.INSTANCE.toRegisterElasticModel(userProfile));
            return true;
        }catch(Exception e) {
            throw new UserManagerException(ErrorType.USER_NOT_CREATED);
        }
    }

    public Boolean activateStatus(Long authId) {
        Optional<UserProfile> userProfile = userProfileRepository.findOptionalByAuthId(authId);
        if(userProfile.isEmpty()) {
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }
        userProfile.get().setStatus(EStatus.ACTIVE);
        update(userProfile.get());
        return true;
    }

    public Boolean update(UserProfileUpdateRequestDto dto) {
        Optional<Long> authId = jwtTokenManager.getIdFromToken(dto.getToken());
        if(authId.isEmpty()) {
            throw new UserManagerException(ErrorType.INVALID_TOKEN);
        }
        Optional<UserProfile> userProfile = userProfileRepository.findOptionalByAuthId(authId.get());
        if(userProfile.isEmpty()) {
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }
        cacheManager.getCache("findbyusername").evict(userProfile.get().getUsername().toLowerCase()); // güncellenen verininin cache'deki eski hâlini siliyoruz.
        if(!dto.getUsername().equals(userProfile.get().getUsername()) || !dto.getEmail().equals(userProfile.get().getEmail())) { // username veya email değişmişse (update edilmişse)
            userProfile.get().setUsername(dto.getUsername());
            userProfile.get().setEmail(dto.getEmail());
            UpdateEmailOrUsernameRequestDto ueourDto = IUserMapper.INSTANCE.toUpdateEmailOrUsernameRequestDto(dto);
            ueourDto.setAuthId(authId.get()); // authId'yi manüel olarak ekledik.
            authManager.updateEmailOrUsername(ueourDto); // UserMikro'dan AuthMikro'ya güncellenmiş veriyi gönderiyoruz, AuthMikro da güncelliyor verisini.
        }
        userProfile.get().setPhone(dto.getPhone());
        userProfile.get().setAvatar(dto.getAvatar());
        userProfile.get().setAddress(dto.getAddress());
        userProfile.get().setAbout(dto.getAbout());
        update(userProfile.get()); // burdaki database'deki veriyi güncelliyoruz.
        return true;

    }

    public Boolean delete(Long authId) {
        Optional<UserProfile> userProfile = userProfileRepository.findOptionalByAuthId(authId);
        if(userProfile.isEmpty()) {
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }
        userProfile.get().setStatus(EStatus.DELETED);
        update(userProfile.get());
        return true;
    }

    @Cacheable(value = "findByUsername", key = "#username.toUpperCase()") // girilen 'username'i küçük harfe çevirerek cache'e alır.
    public UserProfile findByUsername(String username) {
        Optional<UserProfile> userProfile = userProfileRepository.findOptionalByUsernameIgnoreCase(username);
        if(userProfile.isEmpty()) {
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }
        return userProfile.get();
    }

    @Cacheable(value = "findbyrole", key = "#role.toUpperCase()")
    public List<UserProfile> findByRole(String role) {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<Long> authidsList = authManager.findByRole(role).getBody();
        Optional<List<UserProfile>> userProfileListOptional = userProfileRepository.findAllByAuthIdIn(authidsList);
        if(userProfileListOptional.isEmpty()) {
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }
        return userProfileListOptional.get();
    }

    @CacheEvict(cacheNames = "findbyrole", allEntries = true)
    public String redisDelete() {
        return "Ok.";
    }

}
