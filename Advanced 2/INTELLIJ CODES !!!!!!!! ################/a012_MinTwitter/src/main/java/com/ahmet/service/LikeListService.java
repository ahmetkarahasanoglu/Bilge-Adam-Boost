package com.ahmet.service;

import com.ahmet.repository.LikeListRepository;
import com.ahmet.repository.entity.LikeList;
import com.ahmet.utility.MyFactoryService;

public class LikeListService extends MyFactoryService<LikeListRepository, LikeList, Long> {

    public LikeListService() {
        super(new LikeListRepository());
    }
}
