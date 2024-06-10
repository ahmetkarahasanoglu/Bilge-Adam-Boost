package com.ahmet.designpattern.solid.factory_design_pattern;

public class Kamyon extends Tasima{

    public Kamyon() {
        super(ETasimaTipi.KARA);
    }

    @Override
    protected void evrakDoldur() {
        System.out.println("Kamyon evrakı dolduruldu.");
    }
}
