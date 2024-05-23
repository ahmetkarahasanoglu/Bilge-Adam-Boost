package com.ahmet.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    INTERNAL_ERROR(5100, "Sunucu Hatası", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4100, "Parametre Hatası", HttpStatus.BAD_REQUEST),
    LOGIN_ERROR(4110, "Kullanıcı adı veya şifre hatalı!!!", HttpStatus.BAD_REQUEST),
    USERNAME_DUPLICATE(4111, "Böyle bir kullanıcı adı zaten mevcut.", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(4112, "Böyle bir kullanıcı bulunamadı.", HttpStatus.NOT_FOUND),
    ACTIVATE_CODE_ERROR(4113, "Aktivasyon kod hatası", HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(4114, "Geçersiz token", HttpStatus.BAD_REQUEST),
    TOKEN_NOT_CREATED(4115, "Token oluşturulamadı!!!", HttpStatus.BAD_REQUEST),
    ACCOUNT_NOT_ACTIVE(4116, "Hesabınız aktif değil!!!", HttpStatus.FORBIDDEN),
    USER_NOT_CREATED(4117, "Kullanıcı oluşturulamadı!!!", HttpStatus.BAD_REQUEST),
    ROLE_NOT_FOUND(4118, "Böyle bir kullanıcı rolü bulunmamaktadır!!!", HttpStatus.BAD_REQUEST),

                ;

    private int code;
    private String message;
    HttpStatus httpStatus;

}
