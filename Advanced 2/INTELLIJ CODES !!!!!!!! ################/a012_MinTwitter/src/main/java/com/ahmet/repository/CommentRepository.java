package com.ahmet.repository;

import com.ahmet.repository.entity.Comment;
import com.ahmet.utility.MyFactoryRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class CommentRepository extends MyFactoryRepository<Comment,Long> {

    public CommentRepository() {
        super(new Comment());
    }

    public List<Comment> findByTweetId(Long tweetId) {
        TypedQuery<Comment> typedQuery = getEntityManager().createNamedQuery("Comment.findByTweetId", Comment.class);
        typedQuery.setParameter("tweetid", tweetId);
        List<Comment> result = typedQuery.getResultList();
        return result;

    }

}
