package com.ahmet.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbluser")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    String adres;
    String telefon;
    String email;

}
