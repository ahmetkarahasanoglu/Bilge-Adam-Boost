package com.ahmet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewCreateUserRequestDto { // Bu dto, IUserManager vasıtasıyla UserMicroService'e gönderilecek bir dto'dur.

    private Long authId;
    private String username;
    private String email;

}
