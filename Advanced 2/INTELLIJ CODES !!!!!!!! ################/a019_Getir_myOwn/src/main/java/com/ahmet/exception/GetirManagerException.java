package com.ahmet.exception;

import lombok.Getter;

@Getter
public class GetirManagerException extends RuntimeException {

    private final EErrorType errorType;

    public GetirManagerException(EErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public GetirManagerException(EErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

}
