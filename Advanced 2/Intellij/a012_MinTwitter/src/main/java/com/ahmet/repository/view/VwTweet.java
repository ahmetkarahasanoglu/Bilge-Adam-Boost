package com.ahmet.repository.view;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VwTweet {

    Long id;
    Long userid;
    String username;
    String nickName;
    String profileimg;
    Long retweetid;
    Long quotedtweetid;
    Long sharedate;
    String image;
    String content;
    int tweetcomment;
    int tweetlike;
    int retweet;
    int tweetview;

}
