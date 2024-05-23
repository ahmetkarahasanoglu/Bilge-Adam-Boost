package com.ahmet;

public class ErrorPrinter implements IPrinter {

    IProvider provider;

    @Override
    public void print() {
        System.err.println(provider.getMessage()); // mesaj sağlayıcısından gelen mesajı, hata mesajı (err) olarak yazdırıyo
    }

    @Override
    public void setProvider(IProvider provider) {
        this.provider = provider;
    }
}
