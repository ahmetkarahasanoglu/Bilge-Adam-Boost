package com.ahmet.repository.entity;

public class Adres extends BaseEntity {
    Long id;
    Long musteriid;
    String il;
    String ilce;
    String mahalle;

    // CONSTRUCTOR 1:
    public Adres() {
    }

    // CONSTRUCTOR 2:
    public Adres(Long id, Long musteriid, String il, String ilce, String mahalle) {
        this.id = id;
        this.musteriid = musteriid;
        this.il = il;
        this.ilce = ilce;
        this.mahalle = mahalle;
    }

}
