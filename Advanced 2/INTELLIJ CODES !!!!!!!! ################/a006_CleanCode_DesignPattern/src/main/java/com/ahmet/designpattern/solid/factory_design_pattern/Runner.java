package com.ahmet.designpattern.solid.factory_design_pattern;

public class Runner {

    public static void main(String[] args) {

        // --- Yanlış kullanım:
//        Kamyon kamyon1 = new Kamyon(); // Yanlış kullanım; bunun yerine polimorfizm kullanmalıyız (esneklik sağlar)
//        kamyon1.evrakDoldur();

        Tasima tasima;
        tasima = TasimaFactory.builder(ETasimaTipi.DENIZ); // Polimorfizm uyguluyoruz.
        tasima.evrakDoldur();
        tasima = TasimaFactory.builder((ETasimaTipi.KARA));
        tasima.evrakDoldur();



    }//MAIN ENDS HERE ----

}//CLASS ENDS HERE ----
