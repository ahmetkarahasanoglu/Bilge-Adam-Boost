package com.ahmet.repository.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tblsepet")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sepet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long date;
    Double toplamfiyat;

    @Embedded
    BaseEntity baseEntity;

}
