package com.ahmet.Monolitik.repository.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String email;
    String password;
}
