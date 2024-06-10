package com.ahmet.Monolitik.repository.entity;

import lombok.*;

import javax.persistence.*;

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
    String adres;
    String telefon;
    String il;
    String img;
    String username;
    String email;
    String password;
}
