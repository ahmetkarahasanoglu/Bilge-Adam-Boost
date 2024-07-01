package com.ahmet.uber.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tblmusteri")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Musteri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    String soyad;
    String username;
    String password;
    String telefon;
    Long puan;


}
