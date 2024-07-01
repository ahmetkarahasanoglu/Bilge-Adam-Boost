package com.ahmet.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tbldepo")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Depo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isim;
    private String adres;
    private String enlem;
    private String boylam;
    private String konum;
    @OneToMany(mappedBy = "depo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Kurye> kuryeList;


}
