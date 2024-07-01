package com.ahmet;

public class A {

    private String message = "Hello World!";
    @Deprecated
    public String getMessage(){
        return message;
    }

    public String getStandartMessage() {
        return "Standart mesaj..: " + message;
    }

    public String getErrorMessage() {
        return "Error mesaj..: " + message;
    }
}
