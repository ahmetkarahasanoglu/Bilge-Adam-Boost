package com.ahmet.Monolitik.dto.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UrunSaveRequestDto {
    private String ad;
    private String marka;
    private String model;
    private Double fiyat;
}
