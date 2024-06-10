package com.ahmet.uber.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tblkiralama")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Kiralama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long musteriid;
    Long aracid;
    Long soforid;
    Long kiralamatarihi;
    Long onaytarihi;
    Long iptaltarihi;
    Double startlat;
    Double startlon;
    String startkonum;
    KiralamaDurum durum;
    /**
     * Müşterinin şöförü puanlaması
     */
    Long soforpuan;
    /**
     * Şoförün müşteriyi puanlaması
     */
    Long musteripuan;
    Double endlat;
    Double endlon;
    Double endkonum;

}
