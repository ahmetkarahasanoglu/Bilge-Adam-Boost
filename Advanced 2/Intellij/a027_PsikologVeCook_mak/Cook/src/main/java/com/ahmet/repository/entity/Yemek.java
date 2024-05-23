package com.ahmet.repository.entity;

import javax.persistence.Column;

public class Yemek {

    Long id;
    String ad;
    @Column(length = 5000)
    String tarif;
    String url;
    String kisaaciklama;
    String baslik;

}
