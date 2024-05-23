package com.ahmet.uber.exception;

import lombok.Getter;

@Getter
public class UberManagerException extends RuntimeException {

    private final EErrorType errorType;

    public UberManagerException(EErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public UberManagerException(EErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

}
