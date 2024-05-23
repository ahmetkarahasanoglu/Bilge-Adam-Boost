package com.ahmet.manager;

import com.ahmet.dto.request.NewCreateUserRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ahmet.constants.EndPoints.*;

/**
 * Burda AuthMikroservis'imizde, User'a veri göndermek için bir
 * UserManager interface'i kullanıyoruz.
 *    Feign Client ile Mikroservisler arası haberleşme: anlık olarak
 * haberleşmedir, karşı tarafta bir hata olursa bu tarafa da hata
 * düşer. (Buna karşın rabbitmq'da ise kuyruk tipi [bekleme
 * kabiliyetli] haberleşme vardır).
 */
@FeignClient(url = "http://localhost:7072/api/v1/user", decode404 = true, name = "auth-userprofile") // UserMikroServis'in url'si (port 7072) -  '/user:' UserProfileController
public interface IUserManager {


    @PostMapping("/create") // yukardaki url'si yazan (UserMikroServis) / UserProfileController sınıfındaki 'create' metoduna data gönderme usulü.
    public ResponseEntity<Boolean> createUser(@RequestBody NewCreateUserRequestDto dto); // Bu metodun birebir aynı olması lazım UserProfileController'daki 'createUser' metodu ile.
                                                                                         // '--> @RequestBody: dto kullandığımız için @RequestBody kullanmamız gerekiyor.
    @GetMapping(ACTIVATESTATUS+"/{authId}") // path variable kullandık. (RequestParam da kullanabilirdik [aşağıdaki satıra yazarak].
    public ResponseEntity<Boolean> activateStatus(@PathVariable Long authId);

    @DeleteMapping(DELETEBYID)
    public ResponseEntity<Boolean> delete(@RequestParam Long authId);


}
