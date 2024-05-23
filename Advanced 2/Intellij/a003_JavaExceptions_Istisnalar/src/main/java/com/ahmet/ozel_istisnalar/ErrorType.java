package com.ahmet.ozel_istisnalar;

public enum ErrorType {

    ERROR_NOTFOUND_BYID(4001, "Aradığınız öğrenci ID'si bulunamadı."),
    ERROR_EMPTY(4002, "Öğrenci listesi"),
    ERROR_DONT_CREATE(4003, "Öğrenci eklenemedi."),
    ERROR_INVALID_PARAMETER(4004, "Geçersiz öğrenci bilgisi girdiniz.");

    private int code;
    private String message;

    // CONSTRUCTOR 1:
    ErrorType() {
    }

    // CONSTRUCTOR 2:
    ErrorType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // GETTERS AND SETTERS:
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
