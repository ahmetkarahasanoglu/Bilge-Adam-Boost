package com.ahmet.uber.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tblrota")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long aracid;
    String rotaadi;
//    @ElementCollection
//    List<Location> guzergah;

}
