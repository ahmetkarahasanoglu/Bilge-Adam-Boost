package com.ahmet.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tblkurye")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Kurye {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ad;
    private String soyad;
    private String username;
    private String password;
    private String adres;
    private String telefon;
    @ManyToOne
    @JoinColumn(name = "depo_id")
    private Depo depo;

}
