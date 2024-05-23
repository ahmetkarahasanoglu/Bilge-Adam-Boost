package com.ahmet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {

    @NotBlank  // (~validation)
    @Size(min=3, max=20) // (default mesajı vardır bunun ['boyut 3 ile 20 arasında olmalı' şeklinde]. Kendimiz farklı mesaj yazmak için burda parantez içine 'message="En az 3 en çok 20 karakter giriniz' şeklinde yazabiliriz, ancak yazmasak bile bi default mesajı var.
    private String username;
    @Email
    private String email;
    @NotBlank
    @Size(min=5, max=32, message = "Şifre en az 5 karakter en fazla 32 karakter olmalıdır.")
    private String password;

}
