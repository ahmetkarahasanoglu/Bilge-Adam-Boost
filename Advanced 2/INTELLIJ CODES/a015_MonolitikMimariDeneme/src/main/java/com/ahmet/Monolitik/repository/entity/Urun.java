package com.ahmet.Monolitik.repository.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tblurun")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    String marka;
    String model;
    Double fiyat;
    int kdv;
    String barkod;
    int stokadedi;
    String detay;
}
