package com.ahmet.designpattern.solid.dependency;

public class Runner {

    public static void main(String[] args) {

        Odeme odeme = new Odeme();

        odeme.odemeYap(new Cek()); // polimorfizm uyguluyoruz bu satırlarda.
        odeme.odemeYap(new KrediKarti());
        odeme.odemeYap(new Nakit());
        odeme.odemeYap(new DijtalPara());

    }//MAIN ENDS HERE -----

}//MAIN ENDS HERE ----
