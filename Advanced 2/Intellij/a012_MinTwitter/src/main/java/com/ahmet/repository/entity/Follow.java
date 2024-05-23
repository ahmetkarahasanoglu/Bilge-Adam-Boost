package com.ahmet.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * Benim takip ettiğim kişileri bulmak için:
 * select * from tblfollow where userid=?
 * Beni takip eden kişileri bulmak için:
 * select * from tblfollow where followingid=?
 */
@Entity
@Table(name = "")
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long followerid; // Takip eden kişinin (benim) id
    Long followingid; // Takip edilen kişi (takip ettiğim kişinin) id'si

}
