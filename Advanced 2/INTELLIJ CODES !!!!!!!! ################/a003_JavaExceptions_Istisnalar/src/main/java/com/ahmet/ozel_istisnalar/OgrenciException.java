package com.ahmet.ozel_istisnalar;

/**
 * Kendimize özel bir istisna oluşturmak istiyorsak, Exception
 * sınıflarından miras almalıyız ('extends' ile).
 * Constructor mutlaka oluşturun ve kendinize özel hata mesajlarını
 * kullanın.
 */
public class OgrenciException extends RuntimeException{

    private final ErrorType errorType;

    // CONSTRUCTOR 1:
    public OgrenciException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
    // CONSTRUCTOR 2:
    public OgrenciException(String message, ErrorType errorType) { // 'message': RuntimeException sınıfının constructor'ında mevcut olan bir şey olduğu için bu şekilde kullanabiliyoruz.
        super(message);
        this.errorType = errorType;
    }

    // GETTER:
    public ErrorType getErrorType() {
        return this.errorType;
    }

}
