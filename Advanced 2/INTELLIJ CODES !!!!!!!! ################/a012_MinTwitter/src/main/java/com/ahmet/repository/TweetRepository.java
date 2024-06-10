package com.ahmet.repository;

import com.ahmet.repository.entity.Tweet;
import com.ahmet.utility.MyFactoryRepository;

public class TweetRepository extends MyFactoryRepository<Tweet,Long> {

    public TweetRepository() {
        super(new Tweet());
    }
}
