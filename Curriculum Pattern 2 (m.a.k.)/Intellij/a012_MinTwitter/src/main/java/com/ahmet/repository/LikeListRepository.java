package com.ahmet.repository;

import com.ahmet.repository.entity.LikeList;
import com.ahmet.utility.MyFactoryRepository;

public class LikeListRepository extends MyFactoryRepository<LikeList,Long> {

    public LikeListRepository() {
        super(new LikeList());
    }
}
