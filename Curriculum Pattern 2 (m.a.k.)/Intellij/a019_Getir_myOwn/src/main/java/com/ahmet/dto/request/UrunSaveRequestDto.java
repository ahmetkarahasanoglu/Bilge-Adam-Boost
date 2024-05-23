package com.ahmet.dto.request;

import lombok.*;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrunSaveRequestDto {

    private String marka;
    private String isim;
    private Date skt;
    private String barkod;

}
