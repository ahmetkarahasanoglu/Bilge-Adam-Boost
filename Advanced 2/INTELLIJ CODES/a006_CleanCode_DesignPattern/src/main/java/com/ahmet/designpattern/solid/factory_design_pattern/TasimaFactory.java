package com.ahmet.designpattern.solid.factory_design_pattern;

public class TasimaFactory {

    public static Tasima builder(ETasimaTipi tip) {
        switch(tip) {
            case HAVA: return new Ucak();
            case DENIZ: return new Gemi();
            default: return new Kamyon();
        }
    }
}
