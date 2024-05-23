package com.ahmet.repository.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tblsepetdetay")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SepetDetay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long sepetid;
    Long urunid;
    Integer adet;
    Double toplamfiyat;
    Integer kdv;
    Double kdvtutari;

    @Embedded
    BaseEntity baseEntity;
}
