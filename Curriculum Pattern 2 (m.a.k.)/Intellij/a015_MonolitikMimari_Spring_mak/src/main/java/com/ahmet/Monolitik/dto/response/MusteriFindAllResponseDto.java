package com.ahmet.Monolitik.dto.response;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusteriFindAllResponseDto {

    String username;
    String ad;
    String img;

}
