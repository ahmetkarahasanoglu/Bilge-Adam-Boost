package com.ahmet.designpattern.solid.singleton;

public class Runner {

    public static void main(String[] args) {

        // --- Her seferinde new'lemek yanlış bir kullanım; RAM'i şişirir.
//        UrunSingleton urun1 = new UrunSingleton();
//        UrunSingleton urun2 = new UrunSingleton();
//        UrunSingleton urun3 = new UrunSingleton();

        // --- getInstance() metodunu kullanırsak:
//        UrunSingleton urun1 = UrunSingleton.getInstance();
//        UrunSingleton urun2 = UrunSingleton.getInstance();
//        UrunSingleton urun3 = UrunSingleton.getInstance();
//
//        System.out.println("Nesne 1.....: " + urun1);
//        System.out.println("Nesne 2.....: " + urun2);
//        System.out.println("Nesne 3.....: " + urun3);

        for(int i=0; i<20; i++) {
            new Thread(()-> {  // Birden fazla thread, ilk başta, nesneyi null olarak gördüğü için farklı nesneler oluşturur.
                System.out.println(UrunSingleton.getInstance());
            }).start();
        }



    }//MAIN ENDS HERE -----

}//CLASS ENDS HERE -----
