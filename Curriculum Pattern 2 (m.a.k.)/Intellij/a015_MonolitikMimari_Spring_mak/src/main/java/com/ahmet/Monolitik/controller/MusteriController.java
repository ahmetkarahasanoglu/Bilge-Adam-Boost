package com.ahmet.Monolitik.controller;

import static com.ahmet.Monolitik.constants.EndPoints.*;
import com.ahmet.Monolitik.dto.request.MusteriSaveRequestDto;
import com.ahmet.Monolitik.dto.response.MusteriFindAllResponseDto;
import com.ahmet.Monolitik.repository.entity.Musteri;
import com.ahmet.Monolitik.service.MusteriService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
public class MusteriController {

    private final MusteriService musteriService;

    /**
     * !!!! DİKKAT !!!!
     * RestApi; data iletme ve alma işlemlerini yapar, burada data
     * gönderimi ve alımı olabildiğince amaca yönelik ve kısıtlı
     * olmalıdır. Bu nedenle gereksiz şekilde dönülen Entity'ler
     * ve datalar;
     * 1- Güvenlik açığı oluşturur.
     * 2- Performansı mahveder.
     * Bu sorunu çözmek adına DataTransferObject (Dto) kullanırız.
     * Dto ayrıca talep ettiğimiz alanların validasyonunu yapmak
     * için de kullanılır.
     */

    /**
     * Bu sınıf içerisine getirilen isteklerin hangi metodu
     * tetikleyeceğinin bilinmesine ihtiyaç vardır. Bu nedenle
     * metotları işaretlememiz gerekir; bunu
     * Post, Get, Put, Delete vs. gibi işlemlere göre yaparız.
     *
     * http://localhost:9090/musteri/save  -> isteği atıldığında aşağıdaki metot çalışır.
     * ResponseEntity -> Kullanıcıya dönülecek olan datanın bir varlık
     * olarak dönmesi ve bu varlığın Json formatında dönmesi için
     * kullanılır.
     */
    // http://localhost:9090/musteri/save?ad=muhammet&adres=Ankara&telefon=05556667788  -> url girilerek veritabanına kayıt yapılabiliyor.
    @GetMapping(SAVE)
    public ResponseEntity<String> save(MusteriSaveRequestDto dto) {
        musteriService.saveDto(dto);
        return ResponseEntity.ok("Ok.");
    }

    // http://localhost:9090/musteri/getall
    @GetMapping(GETALL)
    public ResponseEntity<List<MusteriFindAllResponseDto>> findAll() {
        return ResponseEntity.ok(musteriService.findAllResponseDtos());
    }

    @GetMapping(GETBYAD)
    public ResponseEntity<Musteri> findByAd(String ad) {
        return ResponseEntity.ok(musteriService.findByAd(ad)); // ResponseEntity -> müşteri nesnesinin bir Json object olarak dönmesini sağlıyor.
    }

}
