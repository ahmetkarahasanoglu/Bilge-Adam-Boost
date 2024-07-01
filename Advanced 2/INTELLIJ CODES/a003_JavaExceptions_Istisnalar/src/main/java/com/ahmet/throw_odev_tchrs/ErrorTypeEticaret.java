package com.ahmet.throw_odev_tchrs;

public enum ErrorTypeEticaret {

    ERROR(4000, "Hata"),
    ERROR_NOTFOUND_BYID(4001, "Aradığınız ürün bulunamadı!(ID ile arama)."),
    ERROR_PRODUCT_NAME(4003, "Böyle bir ürün adı yoktur!"),
    ERROR_PRICE(4004, "Fiyat aralığı bulunamadı"),
    ERROR_EMPTY(4002, "Ürün listesi boş.");

    private int code;
    private String message;

    // CONSTRUCTOR 1:
    ErrorTypeEticaret() {
    }

    // CONSTRUCTOR 2:
    ErrorTypeEticaret(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // GETTERS:
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
