package com.ahmet.Monolitik.dto.request;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrunSaveRequestDto {
    String ad;
    String marka;
    String model;
    Double fiyat;
}
