package com.ahmet.throw_odev_sales;

public enum ErrorType {
    ERROR_NOTFOUND_BYID(4001, "Aradığınız ürün bulunamadı."),
    ERROR_NO_SUCH_PRODUCT_NAME(4002, "Böyle bir ürün adı yok."),
    ERROR_NO_SUCH_PRICE_RANGE(4003, "Böyle bir fiyat aralığı yok.");

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
