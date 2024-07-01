package com.ahmet.Monolitik.controller;

import static com.ahmet.Monolitik.constants.EndPoints.*;

import com.ahmet.Monolitik.dto.request.MusteriLoginRequestDto;
import com.ahmet.Monolitik.dto.request.MusteriSaveRequestDto;
import com.ahmet.Monolitik.dto.response.MusteriFindAllResponseDto;
import com.ahmet.Monolitik.dto.response.MusteriLoginResponseDto;
import com.ahmet.Monolitik.repository.entity.Musteri;
import com.ahmet.Monolitik.service.MusteriService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller - RestController
 * MVC        - RestApi İstekleri için
 * RequestMapping -> Uygulamanıza gelen isteklerin URL içinden analiz
 *    edilerek ulaşması gereken sınıfa ulaştırılması için kullanılır.
 *    Aslında filter işlemi yapılarak yönlendirme yapılmaktadır.
 */
@RestController
@RequestMapping(API+VERSION+MUSTERI) // localhost:9090/musteri -> ile başlayan url girildiğinde bu sınıf çalışır.
@RequiredArgsConstructor // bunun sayesinde Constructor oluşturup musteriService'i new'lememize gerek yok, spring kendisi yapıyor bu anotasyon ile. - Dependency injection açısından kullanışlı.
@CrossOrigin(origins = "http://localhost:5173")
public class MusteriController {

    private final MusteriService musteriService;

    @PostMapping(SAVE)
    public ResponseEntity<String> save(@RequestBody MusteriSaveRequestDto dto) {
        try {
            Thread.sleep(3000);
        }catch(Exception e){

        }
        musteriService.saveDto(dto);
        return ResponseEntity.ok("Ok.");
    }

    @PostMapping(DOLOGIN)
    public ResponseEntity<Boolean> dologin(@RequestBody MusteriLoginRequestDto dto) {
        return ResponseEntity.ok(musteriService.doLogin(dto));
    }

    // http://localhost:9090/musteri/getall
    @GetMapping(GETALL)
    public ResponseEntity<List<MusteriFindAllResponseDto>> findAll(String token) {
        if(token==null || !token.equals("this_is_token")) {
            return ResponseEntity.badRequest().build();
        }else {
            return ResponseEntity.ok(musteriService.findAllResponseDtos());
        }
    }

    @GetMapping(GETBYAD)
    public ResponseEntity<Musteri> findByAd(@RequestParam String ad) {
        return ResponseEntity.ok(musteriService.findByAd(ad)); // ResponseEntity -> müşteri nesnesinin bir Json object olarak dönmesini sağlıyor.
    }

}
