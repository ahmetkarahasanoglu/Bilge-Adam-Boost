package com.ahmet.repository.entity;

import com.ahmet.repository.entity.enums.EUserType;
import com.ahmet.repository.entity.enums.EUserType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * SORU:
 * - userrepository, userservice, usercontroller
 * - register işlemi yapalım ve verileri teker teker alalım:
 *   name, surname, password, email.
 *   Daha sonra database'de kullanıcı kaydı oluşturacağız.
 */

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
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String surname;
    @Column(length = 50)
    private String email;
    @Column(length = 15)
    private String phone;
    @Column(length = 32)
    private String password;
    @ElementCollection // --> User ile favGenreIds arasında veritabanında ayrı bir tablo oluşturulmasını sağlar.
    private List<Long> favGenres;
    @ElementCollection
    private List<Long> favMovies;
    @Enumerated(EnumType.STRING) // enum'ı string olarak tutsun dedik.
    @Builder.Default // default değer verdik:
    private EUserType userType = EUserType.USER;
    @ElementCollection
    private List<Long> comments;

}
