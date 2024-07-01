package com.ahmet.Monolitik.dto.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MusteriFindAllResponseDto {

    private Long id;
    private String ad;
    private String telefon;
//    private String username;
    private String email;
//    private String img;

}
