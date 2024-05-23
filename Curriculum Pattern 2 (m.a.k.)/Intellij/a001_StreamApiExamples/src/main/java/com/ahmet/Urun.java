package com.ahmet;

public class Urun {
    String marka;
    String ad;

    // CONSTRUCTOR 1:
    public Urun() {
    }

    // CONSTRUCTOR 2:
    public Urun(String marka, String ad) {
        this.marka = marka;
        this.ad = ad;
    }

    // GETTERS AND SETTERS:
    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    @Override
    public String toString() {
        return "Urun{" +
                "marka='" + marka + '\'' +
                ", ad='" + ad + '\'' +
                '}';
    }
}
