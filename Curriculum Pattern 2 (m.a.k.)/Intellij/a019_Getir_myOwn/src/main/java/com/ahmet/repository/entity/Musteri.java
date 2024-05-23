package com.ahmet.repository.entity;

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
    private Long id;
    private String ad;
    private String soyad;
    private String username;
    private String password;
    private String adres;
    private String telefon;

}
