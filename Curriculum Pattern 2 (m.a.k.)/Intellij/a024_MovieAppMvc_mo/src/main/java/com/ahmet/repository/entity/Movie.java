package com.ahmet.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tblmovie")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String language;
    private String image;
    private String name;
    private String country;
    private Double rating;
    @Lob
//    @Column(length = 2048)
    private String summary;
    private LocalDate premiered;
    private String url;
    @ElementCollection
    private List<Long> genres;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> comments;

}
