package com.ahmet.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "tblcomment")
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NamedQueries({
        @NamedQuery(name = "Comment.findByTweetId",
                    query = "select c from Comment c where c.tweetid = :tweetid")
})
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long tweetid;
    /**
     * Tweet için yapılan yorum id
     */
    Long commentid;
    /**
     * Tweet'e ya da yorum yapan başka bi kişiye yorum yapan kişi
     */
    Long userid;
    @Column(length = 280)
    String comment;
    Long commentdate;


}
