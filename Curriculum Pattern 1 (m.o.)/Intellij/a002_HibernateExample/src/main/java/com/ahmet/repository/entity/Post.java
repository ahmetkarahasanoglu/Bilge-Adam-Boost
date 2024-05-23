package com.ahmet.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * content
 * date
 * userId
 *    '--> alanlarımız bunlar olacak.
 *    Database'de bir tane post oluşturunuz.
 *
 */
@Entity
@Table(name = "tbl_post")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob // large object - big data olarak tutar.
    private String content;

    private Long userid;

//    @Temporal(TemporalType.TIMESTAMP)  // Not: LocalDate, 'Temporal' ile birlikte kullanılamıyor. Date ise kullanılabiliyor.
    @Builder.Default // --> time atamasını burda yaptık aşağı satırda; bu şekilde başlangıç değeri vermek istiyorsak '@Builder.Default' kullanıyoruz. Böylelikle PostController'da post oluştururken(builder ile) date vermeye gerek kalmadı orda.
    private LocalDateTime date = LocalDateTime.now();

}
