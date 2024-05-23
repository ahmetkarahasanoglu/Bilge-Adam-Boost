package com.bilgeadam.service;

import com.bilgeadam.repository.ClubRepository;
import com.bilgeadam.repository.entity.Club;
import com.bilgeadam.repository.entity.League;
import com.bilgeadam.utility.MyFactoryService;

import java.util.List;
import java.util.Optional;

public class ClubService extends MyFactoryService<ClubRepository, Club, Long> {


    public ClubService() {
        super(new ClubRepository());
    }

    public Optional<Club> findByName(String takimName) {

        List<Club> list = findAllByColumnNameAndValue("club_name", takimName);
        if (list.size() > 0) {
            return Optional.of(list.get(0));
        } else {
            return Optional.empty();
        }

    }


    public Club saveWithName(String name, League league) {
        Optional<Club> takim = findByName(name);
        if (takim.isEmpty()) {
            System.out.println(name + " Takımı Kaydedildi");
            return save(Club.builder().club_name(name).league(league).build());

        } else {
            System.out.println("daha once kaydedilmiştir");
            return takim.get();
        }
    }
}
