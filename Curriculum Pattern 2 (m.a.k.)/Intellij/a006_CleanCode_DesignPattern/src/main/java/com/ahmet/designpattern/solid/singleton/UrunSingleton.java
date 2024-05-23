package com.ahmet.designpattern.solid.singleton;

public class UrunSingleton {

    private static UrunSingleton INSTANCE = null; // pay att: 'static'. pay att: 'INSTANCE'
    private int id;
    private String ad;
    private Double fiyat;

    // CONSTRUCTOR:
    private UrunSingleton() {  // pay att: 'private'
        System.out.println("Nesne oluştu.");
    }

    public static UrunSingleton getInstance() {
        if(INSTANCE == null) {  // when the first time of the assigning, INSTANCE is null.
            INSTANCE = new UrunSingleton(); // '--> new instance is produced only 1 time.
        }
        return INSTANCE;
    }
}
