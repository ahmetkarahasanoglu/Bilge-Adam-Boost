package com.ahmet.Monolitik.repository.entity;

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
    String adres;
    String telefon;
    String il;
    String img;
    String username;
    String password;
    String email;

}
