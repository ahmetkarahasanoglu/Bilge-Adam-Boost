package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String league_name;
    private int league_level;
    @OneToMany(mappedBy = "league")
    List<Club> clubs;


    @Override
    public String toString() { // toString'lere liste eklemeyelim, o şekilde hata vermez.
        return "League{" +     // '--> lombok'un toString'ini kullanmayıp kendimiz toString ekledik.
                "id=" + id +
                ", league_name='" + league_name + '\'' +
                ", league_level=" + league_level +
                '}';
    }
}
