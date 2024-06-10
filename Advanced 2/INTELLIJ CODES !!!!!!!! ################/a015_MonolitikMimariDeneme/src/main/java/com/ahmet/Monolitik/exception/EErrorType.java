package com.ahmet.Monolitik.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EErrorType {

    MUSTERI_BULUNAMADI(1003, "Aradığınız müşteri sistemde kayıtlı değildir.", INTERNAL_SERVER_ERROR),
    URUN_EKLEME(2001, "Ürün ekleme başarısız oldu", INTERNAL_SERVER_ERROR),
    METHOD_MISMATCH_ERROR(2002, "Giriş yaptığınız değer, istenilen değerle uyuşmamaktadır.", BAD_REQUEST),
    METHOD_NOT_VALID_ARGUMENT_ERROR(2003, "URL içinde eksik parametre gönderimi", BAD_REQUEST),
    INVALID_PARAMETER(3001, "Geçersiz parametre girişi yaptınız", BAD_REQUEST),
    PASSWORD_MISMATCH_ERROR(4001, "Şifreler eşleşmiyor.", BAD_REQUEST),
    INCORRECT_CREDENTIALS(4002, "Email veya şifre yanlış.", BAD_REQUEST),
    USER_ALREADY_EXISTS(4003, "Bu kullanıcı adıyla bir hesap zaten mevcut.", BAD_REQUEST),

            ;

    private int code;
    private String message;
    private HttpStatus httpStatus;

}
