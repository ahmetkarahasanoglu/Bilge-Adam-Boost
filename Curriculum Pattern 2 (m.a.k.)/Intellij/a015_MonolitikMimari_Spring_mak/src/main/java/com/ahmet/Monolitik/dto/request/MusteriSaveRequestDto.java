package com.ahmet.Monolitik.dto.request;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusteriSaveRequestDto {
    String ad; // Musteri class'ından sadece ihtiyacımız olan property'leri yazıyoruz burda.
    String adres;
    String telefon;
}
