package com.bilgeadam.service;

import com.bilgeadam.repository.LeagueRepository;
import com.bilgeadam.repository.entity.League;
import com.bilgeadam.utility.MyFactoryService;

public class LeagueService extends MyFactoryService<LeagueRepository, League, Long> {


    public LeagueService() {
        super(new LeagueRepository());
    }
}
