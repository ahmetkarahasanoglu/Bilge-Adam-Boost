package com.ahmet.utility;

import com.ahmet.manager.IUserManager;
import com.ahmet.repository.entity.UserProfile;
import com.ahmet.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllData {

    private final UserProfileService userProfileService; // Elasticsearch'ün içindeki UserProfileService.
    private final IUserManager userManager;

//    @PostConstruct // 1 kez çalıştırcaz, verileri alıp kaydetmek için. ||| Bu sınıftan nesne oluşturulduğunda bu blok çalışacak (Uygulama ayağı kalktığında bu blok çalışacak. - Yukarıdaki alanlardan (@RequiredArgsConstructor ile) nesne oluşturulduktan hemen sonra bu metot çalışacak)
    public void initData() { // UserProfileServis'teki verileri Elasticsearch'e kopyalar. (Uygulama ilk çalıştırılırken bu kodu çalıştırırız).
        List<UserProfile> userProfileList = userManager.findAll().getBody(); // UserProfileMikroServis'ten tüm dataları çekiyoruz.
        userProfileService.saveAll(userProfileList); // yukardaki gelen datayı burda kaydediyoruz (ElasticsearchRepository ile elasticsearch'e kaydediyoruz)
    }

}
