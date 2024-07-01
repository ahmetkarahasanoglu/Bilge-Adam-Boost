package com.ahmet.dto.request;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepoSaveRequestDto {

    String isim;
    String adres;

}
