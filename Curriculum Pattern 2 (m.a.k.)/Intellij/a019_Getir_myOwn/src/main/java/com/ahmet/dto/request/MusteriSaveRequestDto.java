package com.ahmet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusteriSaveRequestDto {

    private String ad;
    private String soyad;
    private String username;
    private String password;
    private String adres;
    private String telefon;

}
