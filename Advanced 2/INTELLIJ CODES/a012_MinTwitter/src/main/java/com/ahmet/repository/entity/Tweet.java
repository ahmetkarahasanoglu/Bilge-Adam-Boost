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
public class Tweet extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userid;
    Long retweetid;
    Long quotedtweetid;
    Long sharedate;
    String image;
    String content;
    int tweetcomment;
    int tweetlike;
    int retweet;
    int tweetview; // burda 'view' değişken adı Postgresql'de sorun çıkartabiliyor, o yüzden 'tweetview' yaptık.

}
