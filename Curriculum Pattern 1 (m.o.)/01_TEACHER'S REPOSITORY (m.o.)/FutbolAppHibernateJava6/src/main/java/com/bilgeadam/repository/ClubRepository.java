package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Club;
import com.bilgeadam.repository.entity.League;
import com.bilgeadam.utility.MyFactoryRepository;

import java.util.List;
import java.util.Optional;

public class ClubRepository extends MyFactoryRepository<Club, Long> {

    public ClubRepository() {
        super(new Club());
    }


    public Optional<Club> findbyName(String clubName) {
        List<Club> clubList = findAllByColumnNameAndValue("club_name", clubName);
        if (clubList.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(clubList.get(0));
        }
    }


    public Club saveWithNameAndLeague(String clubName, League league) {
        Optional<Club> club = findbyName(clubName);
        if (club.isPresent()) {
            System.out.println("Takım daha once olusturulmustur");
            return club.get();
        } else {
            return save(Club.builder().club_name(clubName).league(league).build());
        }
    }


}
