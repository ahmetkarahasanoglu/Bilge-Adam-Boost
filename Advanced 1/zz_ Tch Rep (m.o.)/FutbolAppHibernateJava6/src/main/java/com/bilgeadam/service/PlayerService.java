package com.bilgeadam.service;

import com.bilgeadam.repository.PlayerRepository;
import com.bilgeadam.repository.entity.Player;
import com.bilgeadam.repository.entity.PlayerPositions;
import com.bilgeadam.utility.MyFactoryService;

import java.util.List;

public class PlayerService extends MyFactoryService<PlayerRepository, Player, Long> {


    public PlayerService() {
        super(new PlayerRepository());
    }


    public List<Player> findAllByPositionName(String nextLine) {
        try {
            PlayerPositions ps = PlayerPositions.valueOf(nextLine);
            return getRepository().findAllByPositionName(ps);
        } catch (Exception e) {
            throw new RuntimeException("Boyle bir pozisyon bulunamadı");
        }

    }

    public List<Player> findByPosition(String position) {
        return getRepository().findByPosition(position);
    }

    public List<Player> findByMidfillerPlayer() {
        return getRepository().findByMidfillerPlayer();
    }

    public List<Player> findByArea(String area) {

        return getRepository().findByArea(area);
    }



}
