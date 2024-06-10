package com.ahmet.repository.entity;

public class Malzeme {

    Long id;
    /**
     * Kabak, Patlıcan, Balık, Tuz, Şeker vs.
     */
    String ad;
    EMalzemeType malzemeType;
    /**
     * Ürünün resim adresi linki
     */
    String url;

}
