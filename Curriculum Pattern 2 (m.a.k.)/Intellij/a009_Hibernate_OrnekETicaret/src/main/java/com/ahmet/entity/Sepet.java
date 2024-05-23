package com.ahmet.entity;

import javax.persistence.*;

@Entity
@Table(name = "tblsepet")
public class Sepet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long urunid;

}
