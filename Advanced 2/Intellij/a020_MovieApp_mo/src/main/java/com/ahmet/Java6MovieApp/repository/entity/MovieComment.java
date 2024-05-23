package com.ahmet.Java6MovieApp.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tblmoviecomment")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500)
    private String content;
    private LocalDate date;

    private Long userId;
    private Long movieId;
}
