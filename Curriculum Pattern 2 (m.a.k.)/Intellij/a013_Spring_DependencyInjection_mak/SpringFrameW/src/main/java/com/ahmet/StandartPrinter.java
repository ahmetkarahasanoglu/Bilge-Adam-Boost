package com.ahmet;
// Düz Mesaj yazan sınıf (hata mesajı değil)
public class StandartPrinter implements IPrinter {

    IProvider provider;

    @Override
    public void print() {
        System.out.println(provider.getMessage());
    }

    @Override
    public void setProvider(IProvider provider) {
        this.provider = provider;
    }
}
