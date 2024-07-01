package com.ahmet.throw_odev_tchrs;

public class EticaretException extends RuntimeException {

    private final ErrorTypeEticaret errorTypeEticaret;

    // CONSTRUCTOR 0:
//    public EticaretException(String message) {  // Basic constructor with only a message. With this constructor setting; in Runner when the developoer writes "throw EticaretException()", he can write whatever he wants as a message inside the paranthesis. So to prevent that, in the below constructors we will use enums by using ErrorTypeEticaret.
//        super(message);
//    }

    // CONSTRUCTOR 1:
    public EticaretException(ErrorTypeEticaret errorTypeEticaret) {
        super(errorTypeEticaret.getMessage());
        this.errorTypeEticaret = errorTypeEticaret;
    }

    // CONSTRUCTOR 2:
    public EticaretException(ErrorTypeEticaret errorTypeEticaret, String message) {
        super(message);
        this.errorTypeEticaret = errorTypeEticaret;
    }
}
