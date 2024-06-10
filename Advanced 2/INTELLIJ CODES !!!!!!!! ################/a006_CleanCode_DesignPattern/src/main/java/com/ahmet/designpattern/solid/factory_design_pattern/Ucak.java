package com.ahmet.designpattern.solid.factory_design_pattern;

public class Ucak extends Tasima{

    public Ucak() {
        super(ETasimaTipi.HAVA);
    }

    @Override
    protected void evrakDoldur() {
        System.out.println("Uçak evrakı dolduruldu.");
    }
}
