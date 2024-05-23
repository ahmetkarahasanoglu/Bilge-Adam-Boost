package com.ahmet.Java6MovieApp.controller;

import com.ahmet.Java6MovieApp.dto.request.UserLoginRequestDto;
import com.ahmet.Java6MovieApp.dto.request.UserRegisterRequestDto;
import com.ahmet.Java6MovieApp.dto.response.UserLoginResponseDto;
import com.ahmet.Java6MovieApp.repository.entity.Movie;
import com.ahmet.Java6MovieApp.repository.entity.User;
import com.ahmet.Java6MovieApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.ahmet.Java6MovieApp.constants.EndPoints.*;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor // Otomatik constructor oluşturuyor [best practice'dir, (field'ın üzerine 'Autowired' (final'sız şekilde) yazmaya kıyasla], ('RequiredArgsConstructor kullanımında field'ın 'final' olması lazım). Bu şekilde constructor injection'la new'leme sağlanıyor.
public class UserController {

    private final UserService userService; // 'final' yazdığımız için '@RequiredArgsConstructor' bunun için otomatikman bir constructor oluşturur; (final yazmazsak null gelir); bu şekilde constructor injection'la bu new'lenir.

    // *** Dto kullanmadan User kayıt etme:
    // http://localhost:9090/user/save?name=ahmet&surname=kara&password=123&email=ahmet@gmail.com
//    @GetMapping(SAVE)
//    public ResponseEntity<User> createUser(String name, String surname, @RequestParam Optional<String> password, @RequestParam String email) { // @RequestParam --> email alanının, browser'ın adres çubuğunda mutlaka yazılmasını (ve 'email' şeklinde doğru olarak yazılmasını) gerektirir, yoksa hata verir browser ekranında. / Ayrıca default value kullanılabilir: @RequestParam(defaultValue="example@gmail.com")
//        String mypassword = null;
//        if(password.isPresent()) {
//            mypassword=password.get();
//        }
//        return ResponseEntity.ok(userService.createUser(name, surname, mypassword, email));
//    }


    // *** Dto kullanarak, kullanıcıdan alanları alınan User'ın kaydını oluşturmak:
    @GetMapping("/register")
    public ResponseEntity<User> register(UserRegisterRequestDto dto) { // browser'da kullanıcıdan alınan alanlar (dto alanlarıyla eşleşen alanlar) otomatikman dto'ya dönüştürülüyor (jackson library sayesinde)
        return ResponseEntity.ok(userService.saveDto2(dto));
    }

    @PostMapping("/register2")
    public ResponseEntity<User> register2(@RequestBody UserRegisterRequestDto dto) { // burda alanlar 'body' olarak geliyo (url'de yazmıyoruz). Not: Browser'da URL'ye yazarak sadece GET isteği atılabilir, Post veya Delete isteiği vs. atılamaz. / PostMapping'de veriler gövde (body) olarak gider.
        return ResponseEntity.ok(userService.saveDto2(dto));
    }

    // Kullanıcıları isme göre sıralı getiriniz.
    @GetMapping("/findallorderbyname")
    public ResponseEntity<List<User>> findAllByOrderByName() {
        return ResponseEntity.ok(userService.findAllByOrderByName());
    }

    // Dışarıdan girilen değer hangi kullanıcıların isimlerinde mevcuttur?
    @GetMapping("/containsname")
    public ResponseEntity<List<User>> findByNameContainingIgnoreCase(String value) {
        return ResponseEntity.ok(userService.findByNameContainingIgnoreCase(value));
    }

    // Emaillerinin içinde, belirttiğimiz değer geçen kullanıcılar (yukarıdaki soruyla yapısı aynı)
    @GetMapping("/containsemail")
    public ResponseEntity<List<User>> findByEmailContainingIgnoreCase(String value) {
        return ResponseEntity.ok(userService.findByEmailContainingIgnoreCase(value));
    }

    // Emailleri belirttiğimiz değerle biten kullanıcılar
    @GetMapping("/endingemail")
    public ResponseEntity<List<User>> findByEmailEndingWith(String value) {
        return ResponseEntity.ok(userService.findByEmailEndingWith(value));
    }

    // Email ve password'e göre kullanıcı kontrolü (login). Kullanıcıdan verileri alacağız (request dto), eğer login bilgileri doğruysa, user entity'sinin bazı bilgilerini eleyip geri kalanları döneceğiz (response dto). Login bilgileri yanlışsa RuntimeException fırlatın.
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> login(@RequestBody UserLoginRequestDto dto) { // @RequestBody: @PostMapping kullanıyorsak ve dışarıdan bir nesne alıyorsak @RequestBody yazmak zorundayız.
        return ResponseEntity.ok(userService.login(dto));
    }

    @PostMapping("/login2")
    public ResponseEntity<?> login2(@RequestBody UserLoginRequestDto dto) { // @RequestBody: @PostMapping kullanıyorsak ve dışarıdan bir nesne alıyorsak @RequestBody yazmak zorundayız.
        try {
            return ResponseEntity.ok(userService.login(dto)); // return tipi: UserLoginResponseDto / bi yukarda dönüş tipine '?' koymuştuk; iki türlü dönüş tipimiz var.
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // return tipi: String (mesaj string olarak dönüyo). Hata olursa string dönüyo.
        }
    }

    // Password'unun uzunluğu belirttiğimiz sayıdan büyük olan kullanıcılar (query yazılacak)
    @GetMapping("/passwordcontrol")
    public ResponseEntity<List<User>> passwordLongerThan(int value) {
        return ResponseEntity.ok(userService.passwordLongerThan(value));
    }
    @GetMapping("/passwordcontrol2")
    public ResponseEntity<List<User>> passwordLongerThan2(int value) {
        return ResponseEntity.ok(userService.passwordLongerThan2(value));
    }
    @GetMapping("/passwordcontrol3")
    public ResponseEntity<List<User>> passwordLongerThan3(int value) {
        return ResponseEntity.ok(userService.passwordLongerThan3(value));
    }

}
