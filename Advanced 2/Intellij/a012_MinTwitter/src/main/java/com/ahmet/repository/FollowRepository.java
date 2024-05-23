package com.ahmet.repository;

import com.ahmet.repository.entity.Follow;
import com.ahmet.utility.MyFactoryRepository;

public class FollowRepository extends MyFactoryRepository<Follow,Long> {

    public FollowRepository() {
        super(new Follow());
    }
}
