package com.ahmet.uber.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tblsofor")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sofor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    String soyad;
    String adres;
    String telefon;
    Long puan;

}
