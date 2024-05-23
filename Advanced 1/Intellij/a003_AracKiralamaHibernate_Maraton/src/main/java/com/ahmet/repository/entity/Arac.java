package com.ahmet.repository.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "findAllByDurum", query = "select a from Arac a where a.durum = :durum")
})
public class Arac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String marka;
    private String model;
    private boolean durum; // kirada olup olmadığı (default false olur)
}
