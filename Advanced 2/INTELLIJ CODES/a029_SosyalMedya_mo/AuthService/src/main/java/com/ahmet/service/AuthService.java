package com.ahmet.service;

import com.ahmet.dto.request.*;
import com.ahmet.dto.response.RegisterResponseDto;
import com.ahmet.exception.AuthManagerException;
import com.ahmet.exception.ErrorType;
import com.ahmet.manager.IUserManager;
import com.ahmet.mapper.IAuthMapper;
import com.ahmet.rabbitmq.producer.ActivationProducer;
import com.ahmet.rabbitmq.producer.RegisterProducer;
import com.ahmet.repository.IAuthRepository;
import com.ahmet.repository.entity.Auth;
import com.ahmet.repository.enums.ERole;
import com.ahmet.repository.enums.EStatus;
import com.ahmet.utility.CodeGenerator;
import com.ahmet.utility.JwtTokenManager;
import com.ahmet.utility.ServiceManager;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth,Long> {

    private final IAuthRepository repository;
    private final IUserManager userManager;
    private final JwtTokenManager tokenManager;
    private final CacheManager cacheManager;
    private final RegisterProducer registerProducer;
    private final ActivationProducer activationProducer;

    public AuthService(IAuthRepository repository, IUserManager userManager, JwtTokenManager tokenManager, CacheManager cacheManager, RegisterProducer registerProducer, ActivationProducer activationProducer) {
        super(repository);
        this.repository = repository;
        this.userManager = userManager;
        this.tokenManager = tokenManager;
        this.cacheManager = cacheManager;
        this.registerProducer = registerProducer;
        this.activationProducer = activationProducer;
    }

    @Transactional // otomatik rollback yapar (işlem esnasındaki hata durumunda). FeignClient kullanılan metotta @Transactional kullanmak doğru olur(bu metotta  userManager.createUser()  FeignClient uyguluyor). Karşıdaki mikroservis'e göndermede bir hata olursa '@Transactional' rollback sağlar.
    public RegisterResponseDto register(RegisterRequestDto dto) { // FEIGN CLIENT kullanılcak.
        Auth auth = IAuthMapper.INSTANCE.toAuth(dto);
        auth.setActivationCode(CodeGenerator.generateCode());
        try {
            save(auth);
            userManager.createUser(IAuthMapper.INSTANCE.toNewCreateUserRequestDto(auth)); // UserMikroServis'e gönderiyoruz kaydetmesi için. (Feign Client).
            cacheManager.getCache("findbyrole").evict(auth.getRole().toString()); // cache'deki önceki kayıtları siliyoruz.
        }catch(Exception e) {
//            delete(auth); // rollback işleminin manüel şekilde yapılışı; ama bunu tercih etmiyoz, @Transactional kullanmayı tercih ediyoz.
            throw new AuthManagerException(ErrorType.USER_NOT_CREATED);
        }
        RegisterResponseDto registerResponseDto = IAuthMapper.INSTANCE.toRegisterResponseDto(auth);
        return registerResponseDto;
    }

    @Transactional
    public RegisterResponseDto registerWithRabbitMq(RegisterRequestDto dto) { // RABBITMQ kullanılcak.
        Auth auth = IAuthMapper.INSTANCE.toAuth(dto);
        auth.setActivationCode(CodeGenerator.generateCode());
        try {
            save(auth);
            registerProducer.sendNewUser(IAuthMapper.INSTANCE.toRegisterModel(auth)); // RabbitMq ile veri gönderme (UserMikroServis'e)
            activationProducer.sendForActivation(IAuthMapper.INSTANCE.toActivationModel(auth));
            cacheManager.getCache("findbyrole").evict(auth.getRole().toString()); // cache'deki önceki kayıtları siliyoruz.
        }catch(Exception e) {
//            delete(auth); // rollback işleminin manüel şekilde yapılışı; ama bunu tercih etmiyoz, @Transactional kullanmayı tercih ediyoz.
            throw new AuthManagerException(ErrorType.USER_NOT_CREATED);
        }
        RegisterResponseDto registerResponseDto = IAuthMapper.INSTANCE.toRegisterResponseDto(auth);
        return registerResponseDto;
    }

    public String login(LoginRequestDto dto) {
        Optional<Auth> authOptional = repository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if(authOptional.isEmpty()) {
            throw new AuthManagerException(ErrorType.LOGIN_ERROR); // fırlattığımız bu hata GlobalExceptionHandler sınıfındaki 'handleManagerException' metodu tarafından yakalanıyor, ordan browser'a exception'la ilgili bir Json gidiyor.
        }
        if(!authOptional.get().getStatus().equals(EStatus.ACTIVE)) {
            throw new AuthManagerException(ErrorType.ACCOUNT_NOT_ACTIVE);
        }
        return tokenManager.createToken(authOptional.get().getId(), authOptional.get().getRole()).orElseThrow(()-> {
            throw new AuthManagerException(ErrorType.TOKEN_NOT_CREATED);
        });

    }

    public Boolean activateStatus(ActivateRequestDto dto) {
        Optional<Auth> auth = findById(dto.getId());
        if(auth.isEmpty()) {
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        }
        if(dto.getActivationCode().equals(auth.get().getActivationCode())) {
            auth.get().setStatus(EStatus.ACTIVE);
            update(auth.get()); // save() metodu kullanmıyoruz, update() kullanıyoruz; çünkü createDate ve updateDate'in değişmesini istemiyoruz ('save' metodu tanımlaması içinde bunlar değişiyor).
            userManager.activateStatus(auth.get().getId());
            return true;
        }else {
            throw new AuthManagerException(ErrorType.ACTIVATE_CODE_ERROR);
        }
    }


    public Boolean updateEmailOrUsername(UpdateEmailOrUsernameRequestDto dto) {
        Optional<Auth> auth = repository.findById(dto.getAuthId());
        if(auth.isEmpty()) {
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        }
        auth.get().setEmail(dto.getEmail());
        auth.get().setUsername(dto.getUsername());
        update(auth.get());
        return true;
    }

    @Transactional
    public Boolean delete(Long id) {
        Optional<Auth> auth = repository.findById(id);
        if(auth.isEmpty()) {
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        }
        auth.get().setStatus(EStatus.DELETED);
        update(auth.get());
        userManager.delete(id);
        return true;
    }

    public List<Long> findByRole(String role) {
        ERole myrole;
        try {
            myrole = ERole.valueOf(role.toUpperCase(Locale.ENGLISH)); // String'i ERole'e çeviriyoruz.
        }catch(Exception e) {
            throw new AuthManagerException(ErrorType.ROLE_NOT_FOUND);
        }
        List<Auth> authList = repository.findAllByRole(myrole);
        List<Long> idsList = new ArrayList<>();
        for(Auth auth : authList) {
            idsList.add(auth.getId());
        }
        return idsList;
    }

}
