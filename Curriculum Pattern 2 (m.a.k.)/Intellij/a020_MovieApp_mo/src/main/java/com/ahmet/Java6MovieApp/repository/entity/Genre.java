package com.ahmet.Java6MovieApp.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tblgenre")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
