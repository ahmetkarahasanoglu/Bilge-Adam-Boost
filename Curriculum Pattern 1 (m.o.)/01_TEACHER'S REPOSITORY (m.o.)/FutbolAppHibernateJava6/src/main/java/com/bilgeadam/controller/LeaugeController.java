package com.bilgeadam.controller;

import com.bilgeadam.repository.entity.League;
import com.bilgeadam.service.LeagueService;

public class LeaugeController {

    LeagueService leagueService;

    public LeaugeController() {
        this.leagueService = new LeagueService();
    }

    public void createLeague(League league) {
        leagueService.save(league);
    }

    public void deleteById(long id) {
        leagueService.deleteById(id);
    }
}
