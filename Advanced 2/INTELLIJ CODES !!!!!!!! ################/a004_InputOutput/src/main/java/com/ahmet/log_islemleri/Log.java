package com.ahmet.log_islemleri;

import java.io.Serializable;
import java.util.UUID;

/**
 * ÖMEMLİ!!!!!!!!!!
 * Dosya olarak kayıt edilecek sınıfların mutlaka serileştirilmesi
 * gerekmektedir(implements Serializable) yapmak gerekmektedir.
 */
public class Log implements Serializable { // pay att: Serializable
    String id;
    String errorMessage;
    Integer errorCode;
    String className;
    String methodName;
    Long timeStamp;
    String detail;

    // CONSTRUCTOR 1:
    public Log() {
    }

    // CONSTRUCTOR 2:
    public Log(String errorMessage, Integer errorCode, String className, String methodName, Long timeStamp, String detail) {
        this.id = UUID.randomUUID().toString();
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.className = className;
        this.methodName = methodName;
        this.timeStamp = timeStamp;
        this.detail = detail;
    }

    // GETTERS AND SETTERS:
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    // METHODS: -----
    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", timeStamp=" + timeStamp +
                ", detail='" + detail + '\'' +
                '}';
    }
}
