package com.ahmet.Monolitik.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MusteriLoginResponseDto {
    private String ad;
    private String img;
    private String username;
    private String email;
}
