package com.ahmet.Monolitik.dto.request;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusteriSaveRequestDto {
//    String username; // Musteri class'ından sadece ihtiyacımız olan property'leri yazıyoruz burda.
    String email;
    String password;
//    String repassword;
    String ad;
    String soyad;
//    String adres;
    String telefon;
}
