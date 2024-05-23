package com.ahmet.service;

import com.ahmet.repository.FollowRepository;
import com.ahmet.repository.entity.Follow;
import com.ahmet.utility.MyFactoryService;

public class FollowService extends MyFactoryService<FollowRepository, Follow, Long> {

    public FollowService() {
        super(new FollowRepository());
    }
}
