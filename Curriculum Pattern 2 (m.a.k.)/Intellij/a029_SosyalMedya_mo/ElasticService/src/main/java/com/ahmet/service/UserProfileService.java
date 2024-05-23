package com.ahmet.service;


import com.ahmet.mapper.IElasticMapper;
import com.ahmet.rabbitmq.model.RegisterElasticModel;
import com.ahmet.repository.IUserProfileRepository;
import com.ahmet.repository.entity.UserProfile;
import com.ahmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

/** UserMikroServis'te findByRole diye bir metot yazalım. Bu metot
 * girdiğimiz role göre bize database'deki userProfile'ları dönsün.
 * Ayrıca bu metodu cache'leyelim. Bir de bu cache ne zaman ve
 * nasıl silinir, bununla ilgili kodları da yazın.
 */

@Service
public class UserProfileService extends ServiceManager<UserProfile,String> {

    private final IUserProfileRepository userProfileRepository;

    public UserProfileService(IUserProfileRepository userProfileRepository) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile createUserWithRabbitMq(RegisterElasticModel model) {
        return save(IElasticMapper.INSTANCE.toUserProfile(model));
    }
}
