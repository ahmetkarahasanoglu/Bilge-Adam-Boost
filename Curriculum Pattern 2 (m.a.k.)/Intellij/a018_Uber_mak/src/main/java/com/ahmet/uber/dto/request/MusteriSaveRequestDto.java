package com.ahmet.uber.dto.request;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusteriSaveRequestDto {

    String ad;
    String soyad;
    String username;
    String password;
    String telefon;

}
