package com.ahmet.Monolitik.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusteriLoginResponseDto {
    String ad;
    String img;
    String username;
    String email;
}
