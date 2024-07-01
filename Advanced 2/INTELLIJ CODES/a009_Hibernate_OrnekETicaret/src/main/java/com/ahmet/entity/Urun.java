package com.ahmet.entity;

import javax.persistence.*;

@Entity
@Table(name = "tblurun")
public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    Double fiyat;

    public Urun() {
    }

    public Urun(Long id, String ad, Double fiyat) {
        this.id = id;
        this.ad = ad;
        this.fiyat = fiyat;
    }

    public Urun(String ad, Double fiyat) {
        this.ad = ad;
        this.fiyat = fiyat;
    }

    // GETTERS AND SETTERS:
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public Double getFiyat() {
        return fiyat;
    }

    public void setFiyat(Double fiyat) {
        this.fiyat = fiyat;
    }
}
