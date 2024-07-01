package com.ahmet.Monolitik.dto.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MusteriSaveRequestDto {
//    private String username; // Musteri class'ından sadece ihtiyacımız olan property'leri yazıyoruz burda.
    private String email;
    private String password;
//    private String repassword;
    private String ad;
    private String soyad;
//    private String adres;
    private String telefon;
}
