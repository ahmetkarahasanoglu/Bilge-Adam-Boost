package com.ahmet.entity;

import javax.persistence.*;

@Entity
@Table(name = "tblsatis")
public class Satis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long tarih;

}
