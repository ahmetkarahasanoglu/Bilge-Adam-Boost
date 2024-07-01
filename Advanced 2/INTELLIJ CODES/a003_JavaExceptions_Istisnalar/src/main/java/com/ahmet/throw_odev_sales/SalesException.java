package com.ahmet.throw_odev_sales;

public class SalesException extends RuntimeException {

    private final ErrorType errorType;

    // CONSTRUCTOR 1:
    public SalesException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
    // CONSTRUCTOR 2:
    public SalesException(String message, ErrorType errorType) { // message: RuntimeException sınıfının constructor'ında mevcut olan bir şey olduğu için bu şekilde kullanabiliyoruz.
        super(message);
        this.errorType = errorType;
    }

    // GETTER:
    public ErrorType getErrorType() {
        return this.errorType;
    }

}
