package com.bilgeadam;

import com.bilgeadam.controller.ClubController;
import com.bilgeadam.controller.LeaugeController;
import com.bilgeadam.controller.PlayerController;
import com.bilgeadam.repository.entity.Club;
import com.bilgeadam.repository.entity.League;
import com.bilgeadam.repository.entity.Player;
import com.bilgeadam.repository.entity.PlayerPositions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static List<List<String>> newList = new ArrayList<>();
    static List<Player> players = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        ClubController clubController = new ClubController();
        PlayerController playerController = new PlayerController();
        LeaugeController leaugeController = new LeaugeController();
        League league = League.builder().league_name("superlig").build();
        Club club = Club.builder().club_name("MyClub").league(league).build();
//
        Player player = Player.builder().long_name("futbolcu1").player_positions(PlayerPositions.GK).club(club).build();
        Player player2 = Player.builder().long_name("futbolcu2").player_positions(PlayerPositions.GK).club(club).build();
        Player player3 = Player.builder().long_name("futbolcu3").player_positions(PlayerPositions.CM).club(club).build();
        //1den fazla player kaydediyor
        playerController.createPlayers(List.of(player2, player, player3));
        //      playerController.createPlayer(player);
//
        playerController.findAll().forEach(System.out::println);
//
//
//        //   playerController.deleteById(1L);
//        //   playerController.deleteByEntity(player);
//        //     clubController.deleteById(1L);
//        //  leaugeController.deleteById(1L);

//        System.out.println(PlayerPositions.CM.getArea());
//        List<PlayerPositions> ps = Arrays.asList(PlayerPositions.values()).stream()
//                .filter(x -> x.getArea().equals("Defans")).collect(Collectors.toList());
//
//        ps.forEach(System.out::println);
//    }


    }
}


