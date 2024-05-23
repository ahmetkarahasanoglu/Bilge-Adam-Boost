package com.ahmet.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kisi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String name;
    private String username;
    private String password;
    @OneToMany(mappedBy = "kisi")
    private List<Kiralama> kiralamalar;

//    @Override
//    public String toString() {
//        return "Kisi{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}
