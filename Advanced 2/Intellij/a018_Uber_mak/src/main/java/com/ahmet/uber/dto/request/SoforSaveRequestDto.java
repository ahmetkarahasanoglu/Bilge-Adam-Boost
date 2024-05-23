package com.ahmet.uber.dto.request;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoforSaveRequestDto {

    String ad;
    String soyad;
    String adres;
    String telefon;

}
