package com.ahmet;

public class Print {

    public void print(MessageType type) {
        switch(type) {
            case ERROR -> System.err.println("Hata oldu.");
            case STANDART -> System.out.println("Merhaba dünya.");
        }
    }

}
