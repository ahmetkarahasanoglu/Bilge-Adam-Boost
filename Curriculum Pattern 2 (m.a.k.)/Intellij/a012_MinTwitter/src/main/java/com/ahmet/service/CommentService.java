package com.ahmet.service;

import com.ahmet.repository.CommentRepository;
import com.ahmet.repository.UserProfileRepository;
import com.ahmet.repository.entity.Comment;
import com.ahmet.utility.MyFactoryRepository;
import com.ahmet.utility.MyFactoryService;

import java.util.List;

public class CommentService extends MyFactoryService<CommentRepository, Comment, Long> {

    public CommentService() {
        super(new CommentRepository());
    }

    public List<Comment> findByTweetId(Long tweetId) {
        return getRepository().findByTweetId(tweetId);
    }

}
