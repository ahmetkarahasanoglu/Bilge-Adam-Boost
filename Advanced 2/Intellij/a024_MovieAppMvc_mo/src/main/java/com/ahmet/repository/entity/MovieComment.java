package com.ahmet.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
