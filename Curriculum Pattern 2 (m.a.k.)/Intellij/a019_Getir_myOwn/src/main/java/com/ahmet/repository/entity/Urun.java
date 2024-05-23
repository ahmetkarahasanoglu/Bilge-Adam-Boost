package com.ahmet.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tblurun")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marka;
    private String isim;
    private Date skt;
    private String barkod;

}
