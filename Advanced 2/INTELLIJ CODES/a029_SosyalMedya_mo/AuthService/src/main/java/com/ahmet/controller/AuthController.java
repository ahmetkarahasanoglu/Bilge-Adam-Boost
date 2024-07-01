package com.ahmet.controller;

import com.ahmet.dto.request.*;
import com.ahmet.dto.response.RegisterResponseDto;
import com.ahmet.repository.entity.Auth;
import com.ahmet.repository.enums.ERole;
import com.ahmet.service.AuthService;
import com.ahmet.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.ahmet.constants.EndPoints.*;

/**
 * Şu İşlemleri Yapınız:
 * - login metodu yazalım. Dışarıdan login olmak için gerekli
 * parametreleri alalım. Eğer bilgiler doğru ise true, yanlış ise
 * false dönsün.
 *
 * status'u active hale getirdiğim zaman usermikroservis'te de
 * status'um active hale gelsin (AuthService'den).
 *
 * login metodumuzu düzeltelim; Bize bir token üretip token'ı
 * dönsün. Ayrıca sadece 'active' kullanıcılar login olabilsin.
 *
 * Update metodu oluşturunuz.
 *
 * Delete işleminde verimizi silmiyoruz, sadece status'ünü
 * değiştiriyoruz. Burda delete metodunu yazalım; UserMikro'ya
 * da etki etsin.
 */

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtTokenManager tokenManager;
    private final CacheManager cacheManager;

    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto) { // '@Valid': AuthRegisterRequestDto sınıfındaki validasyon anotasyonlarımızı uygular; validasyon'dan geçmezse bu metodun içine hiç girmez (aşağıdaki satırı çalıştırmaz)
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping(REGISTER+"2")
    public ResponseEntity<RegisterResponseDto> registerWithRabbitMq(@RequestBody @Valid RegisterRequestDto dto) { // '@Valid': AuthRegisterRequestDto sınıfındaki validasyon anotasyonlarımızı uygular; validasyon'dan geçmezse bu metodun içine hiç girmez (aşağıdaki satırı çalıştırmaz)
        return ResponseEntity.ok(authService.registerWithRabbitMq(dto));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<String> login(@RequestBody LoginRequestDto dto) {
        return ResponseEntity.ok(authService.login(dto)); // başarılı olmuşsa: 200 http code
    }

    @PostMapping(ACTIVATESTATUS)
    public ResponseEntity<Boolean> activateStatus(@RequestBody ActivateRequestDto dto) {
        return ResponseEntity.ok(authService.activateStatus(dto));
    }

    @PreAuthorize("hasAuthority('USER')") // Sadece 'User' yetkisine sahip kişiler bu metoda erişebilir; diğerleri '403 Forbidden' alır.
    @GetMapping(FINDALL)
    public ResponseEntity<List<Auth>> findAll() {
        return ResponseEntity.ok(authService.findAll());
    }


    @GetMapping("/createtoken")
    public ResponseEntity<String> createToken(Long id, ERole role) {
        return ResponseEntity.ok(tokenManager.createToken(id, role).get());
    }

    @GetMapping("/createtoken2")
    public ResponseEntity<String> createToken(Long id) {
        return ResponseEntity.ok(tokenManager.createToken(id).get());
    }

    @GetMapping("/getidfromtoken")
    public ResponseEntity<Long> getIdFromToken(String token) {
        return ResponseEntity.ok(tokenManager.getIdFromToken(token).get());
    }

    @PreAuthorize("hasAuthority('ADMIN')") // Sadece 'Admin' yetkisine sahip kişiler bu metoda erişebilir; diğerleri '403 Forbidden' alır.
    @GetMapping("/getrolefromtoken")
    public ResponseEntity<String> getRoleFromToken(String token) {
        return ResponseEntity.ok(tokenManager.getRoleFromToken(token).get());
    }

    @PutMapping("/updateemailorusername")
    public ResponseEntity<Boolean> updateEmailOrUsername(@RequestBody UpdateEmailOrUsernameRequestDto dto) {
        return ResponseEntity.ok(authService.updateEmailOrUsername(dto));
    }

    @DeleteMapping(DELETEBYID) // '@DeleteMapping': metodun işleviyle uyuşsun diye bunu kullandık (@PostMapping de kullansak çalışırdı).
    public ResponseEntity<Boolean> delete(@RequestParam Long id) {
        return ResponseEntity.ok(authService.delete(id));
    }

    @GetMapping("/redis")
    @Cacheable(value = "redisexample")
    public String redisExample(String value) {
        try {
            Thread.sleep(2000); // swagger'dan ilk istek attığımızda bu metodun içi çalışıyor, 2000 küsür milisaniye bekliyor. Ama, aynı string value ile sonraki çalıştırmalarımızda 500 küsür milisaniye sürüyor, çünkü cache'e atıyor, hızlı çalışıyor.
            return value;
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/redisdelete") //  (cache'lemeler genelde servis'te yapılır. Biz örnek olarak controller'da denedik burda)
    @CacheEvict(cacheNames = "redisexample", allEntries = true) // 1. Yöntem. ||| cache'deki "redisexample" ismiyle yapılmış kayıtları siler.
    public void redisDelete() {
    }

    @GetMapping("/redisdelete2")
    public Boolean redisDelete2() {
        try {
//            cacheManager.getCache("redisexample").clear(); // 2.yöntem - cache'deki kaydı silmek için
            cacheManager.getCache("redisexample").evict("mustafa"); // "redisexample" ismiyle kaydedilmiş olan "mustafa"yı silecek. (bunlar key-value gibi tutulur: (redisexample: mustafa)
            return true;
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(FINDBYROLE)
    public ResponseEntity<List<Long>> findByRole(@RequestParam String role) {
        return ResponseEntity.ok(authService.findByRole(role));
    }


}
