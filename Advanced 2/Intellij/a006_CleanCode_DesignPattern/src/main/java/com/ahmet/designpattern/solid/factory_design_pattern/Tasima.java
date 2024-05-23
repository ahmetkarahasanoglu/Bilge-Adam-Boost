package com.ahmet.designpattern.solid.factory_design_pattern;

public abstract class Tasima {

    private ETasimaTipi tip = null;

    // CONSTRUCTOR:
    public Tasima(ETasimaTipi tip) {
        this.tip = tip;
        log();
    }

    // GETTER AND SETTER:
    public ETasimaTipi getTip() {
        return tip;
    }

    public void setTip(ETasimaTipi tip) {
        this.tip = tip;
    }

    // METHODS: ---
    private void log() {
        System.out.println("Sistem loglama kodları burada yazılabilir.");
    }

    /**
     * Tüm sınıfların, içini kendi yapısına göre doldurmasını
     * istediğim sözleşme mantığı ile tanımlıyoruz:
     */
    protected abstract void evrakDoldur();  // abstract method
}
