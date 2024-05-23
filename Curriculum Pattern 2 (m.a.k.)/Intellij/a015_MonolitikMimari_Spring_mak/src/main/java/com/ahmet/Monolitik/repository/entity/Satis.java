package com.ahmet.Monolitik.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * Tüm Katmanlar yazılacak (Mapper dahil)
 * Ne zaman
 * Kime
 * Ne kadar
 * Ne
 * satıldı?
 * SORGU:
 * 1- Kime ne satıldı listesi
 * 2- A kişisine neler satıldı listesi
 * 3- En çok satış adedi olan müşteri
 * 4- En çok satılan 3 ürün
 */
@Entity
@Table(name = "tblsatis")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Satis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long musteriid;
    Long urunid;
    Long tarih;
    int adet;
    Double birimfiyat;
    Double toplamfiyat;




}
