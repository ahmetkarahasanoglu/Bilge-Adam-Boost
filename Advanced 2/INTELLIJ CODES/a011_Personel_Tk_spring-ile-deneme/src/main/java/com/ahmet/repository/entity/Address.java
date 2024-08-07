package com.ahmet.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbladdress")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String city;
    String zipCode;
    String number;
    String street;

}
