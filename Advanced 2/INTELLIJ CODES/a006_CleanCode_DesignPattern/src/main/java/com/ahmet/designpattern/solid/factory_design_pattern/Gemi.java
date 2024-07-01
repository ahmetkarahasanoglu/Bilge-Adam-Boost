package com.ahmet.designpattern.solid.factory_design_pattern;

public class Gemi extends Tasima{

    public Gemi() {
        super(ETasimaTipi.DENIZ);
    }

    @Override
    protected void evrakDoldur() {
        System.out.println("Gemi evrakı dolduruldu.");
    }
}
