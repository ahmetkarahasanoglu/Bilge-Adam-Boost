package com.ahmet.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileUpdateRequestDto {

    private String token; // (token kullanıyoruz kullanıcıyı ayırt etmek için)
    private String username;
    private String email;
    private String phone;
    private String avatar;
    private String address;
    private String about;

}
