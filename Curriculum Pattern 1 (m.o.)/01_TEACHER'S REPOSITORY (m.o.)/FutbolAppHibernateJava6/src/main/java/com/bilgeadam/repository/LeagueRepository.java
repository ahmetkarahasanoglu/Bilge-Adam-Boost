package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.League;
import com.bilgeadam.utility.MyFactoryRepository;

public class LeagueRepository extends MyFactoryRepository<League, Long> {

    public LeagueRepository() {
        super(new League());
    }
}
