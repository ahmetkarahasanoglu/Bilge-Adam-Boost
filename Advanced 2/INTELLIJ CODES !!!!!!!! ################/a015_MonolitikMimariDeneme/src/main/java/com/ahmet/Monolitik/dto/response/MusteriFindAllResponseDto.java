package com.ahmet.Monolitik.dto.response;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusteriFindAllResponseDto {

    Long id;
    String ad;
    String telefon;
//    String username;
    String email;
//    String img;

}
