package com.ahmet.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice // -> Başına 'Rest' ekleyince aşağıdaki metotlarda '@ResponseBody' kullanmamıza gerek kalmadı. ||| Provides centralized exception handling for RESTful APIs.
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException exception){
        return ResponseEntity.ok("Beklenmeyen bir hata olustu: "+exception.getMessage());
    }

    @ExceptionHandler(UserManagerException.class)
    public ResponseEntity<ErrorMessage> handleManagerException(UserManagerException exception) { // Kendi yazdığımız AuthManagerException hatasını kodumuzda fırlattığımızda (o kod çalıştığında) bu metot yakalar.
        ErrorType errorType = exception.getErrorType();
        HttpStatus httpStatus = errorType.httpStatus;
        return new ResponseEntity<>(createError(errorType,exception), httpStatus);
    }

    private ErrorMessage createError(ErrorType errorType, Exception exception) { // 'private' kullandık; dışarıdan erişilmesin, sadece bu class'da kullanılabilsin.
        System.out.println("Hata oluştu: " + exception.getMessage());
        return ErrorMessage.builder()
                .code(errorType.getCode())
                .message(errorType.getMessage())
                .build();
    }

    @ExceptionHandler(DataIntegrityViolationException.class) // Şu exception'ı yakalamak için yazıyoruz: Auth entity'deki username'i @Column(unique=true) şeklinde unique yaptmıştık; browser'dan daha önce kayıtlı olan bir username ile register yaptığımızda bir hata oluşuyordu: DataIntegrityViolationException . Onu yakalamak için bu metodu yazıyoruz.
    public ResponseEntity<ErrorMessage> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        ErrorType errorType = ErrorType.USERNAME_DUPLICATE;
        HttpStatus httpStatus = errorType.httpStatus;
        return new ResponseEntity<>(createError(errorType,exception), httpStatus);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) { // Örneğin kullanıcı register yaparken validasyonumuza aykırı veri girdiğinde (username, email alanı vs.) MethodArgumentNotValidException fırlatır Java. - Burda onu yakalıyoruz.
        ErrorType errorType = ErrorType.BAD_REQUEST;                                                                             // '--> 'final' keyword means: this method cannot be overridden by any subclasses of the class in which it is defined(GlobalExceptionHandler class).
        List<String> fields = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(e->fields.add(e.getField() + ": " + e.getDefaultMessage())); // field'ı ve message'ı bir string'de birleştiriyoruz.
        ErrorMessage errorMessage = createError(errorType,exception);
        errorMessage.setFields(fields); // ErrorMessage sınıfımızdan nesnenin 'fields' alanına, yukarıdaki getField ve getDefaultMessage 'lardan oluşan 'fields' ArrayList'ini atıyoruz.
        return new ResponseEntity<>(errorMessage,errorType.getHttpStatus()); // '--> Böylelikle, kullanıcı geçersiz bir veri girdiğinde şunun gibi bir Response body dönüşü olcak:  "fields": [ "email: düzgün biçimli bir e-posta adresi değil!", "username: boyut 3 ile 20 arasında olmalı" ], "code": 4100, "message": "Parametre Hatası"( -> kendi yazdığımız ErrorType'da yazan mesaj).
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<ErrorMessage> handleMessageNotReadableException(
            HttpMessageNotReadableException exception) {
        ErrorType errorType = ErrorType.BAD_REQUEST;
        return new ResponseEntity<>(createError(errorType, exception), errorType.getHttpStatus());
    }

    @ExceptionHandler(InvalidFormatException.class)
    public final ResponseEntity<ErrorMessage> handleInvalidFormatException(
            InvalidFormatException exception) {
        ErrorType errorType = ErrorType.BAD_REQUEST;
        return new ResponseEntity<>(createError(errorType, exception), errorType.getHttpStatus());
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public final ResponseEntity<ErrorMessage> handleMethodArgumentMisMatchException(
            MethodArgumentTypeMismatchException exception) {
        ErrorType errorType = ErrorType.BAD_REQUEST;
        return new ResponseEntity<>(createError(errorType, exception), errorType.getHttpStatus());
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public final ResponseEntity<ErrorMessage> handleMethodArgumentMisMatchException(
            MissingPathVariableException exception) {
        ErrorType errorType = ErrorType.BAD_REQUEST;
        return new ResponseEntity<>(createError(errorType, exception), errorType.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)  // --> a general exception catcher
    public final ResponseEntity<ErrorMessage> handleAllExceptions(Exception exception) {
        ErrorType errorType = ErrorType.INTERNAL_ERROR;
        List<String> fields = new ArrayList<>();
        fields.add(exception.getMessage());
        ErrorMessage errorMessage = createError(errorType, exception);
        errorMessage.setFields(fields);
        return new ResponseEntity<>(createError(errorType, exception), errorType.getHttpStatus());
    }

}
