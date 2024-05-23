package com.ahmet.uber.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tblarac")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Arac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String plaka;
    AracTuru aracturu;
    Long soforid;
    Double fiyat;
    KiralamaDurum durum;
    Double lat;
    Double lon;
    String konum;

}
