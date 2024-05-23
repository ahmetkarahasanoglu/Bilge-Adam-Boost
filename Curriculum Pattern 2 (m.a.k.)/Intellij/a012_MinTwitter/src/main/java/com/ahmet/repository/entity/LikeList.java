package com.ahmet.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "")
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LikeList extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long tweetid;
    Long userid;
    Long likeddate;

}
