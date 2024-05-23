package com.bilgeadam.utility;

import com.bilgeadam.controller.PlayerController;
import com.bilgeadam.repository.ClubRepository;
import com.bilgeadam.repository.entity.Club;
import com.bilgeadam.repository.entity.League;
import com.bilgeadam.repository.entity.Player;
import com.bilgeadam.repository.entity.PlayerPositions;
import com.bilgeadam.repository.entity.embeded.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataImpl {

    public static void main(String[] args) {
        List<List<String>> newList = new ArrayList<>();

        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader("E:/futbol/superlig7.csv", StandardCharsets.UTF_8));
            String line = "";

            while ((line = bufferedReader.readLine()) != null) {

                newList.add(Arrays.asList(line.split(";")));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        newList.remove(0);
        League league = League.builder()
                .league_name(newList.get(0).get(10))
                .league_level(Integer.parseInt(newList.get(0).get(11)))
                .build();

        newList.forEach(System.out::println);
        newList.forEach(x -> {
            createPlayer(x, league);
        });
    }

    private static void createPlayer(List<String> list, League league) {
        /*


         */
        PlayerController playerController = new PlayerController();
        ClubRepository clubRepository = new ClubRepository();
        Club club = clubRepository.saveWithNameAndLeague(list.get(9), league);

        Player player = Player.builder()
                .long_name(list.get(0))
                .player_positions(PlayerPositions.valueOf(list.get(1).split(",")[0]))
                .overall(Integer.parseInt(list.get(2)))
                .potential(Integer.parseInt(list.get(3)))
                .value_eur(Double.parseDouble(list.get(4)))
                .wage_eur(Double.parseDouble(list.get(5)))
                .age(Integer.parseInt(list.get(6)))
                .height_cm(Double.parseDouble(list.get(7)))
                .weight_kg(Double.parseDouble(list.get(8)))
                .club_position(list.get(12))
                .club_jersey_number(Integer.parseInt(list.get(13)))
                .club_contract_valid_until(list.get(14))
                .nationality_name(list.get(15))
                .preferred_foot(list.get(16))
                .pace(Integer.parseInt(list.get(17)))
                .shooting(Integer.parseInt(list.get(18)))
                .passing(Integer.parseInt(list.get(19)))
                .dribbling(Integer.parseInt(list.get(20)))
                .defending(Integer.parseInt(list.get(21)))
                .physic(Integer.parseInt(list.get(22)))
                .attacking(createAttacking(list.subList(23, 28)))
                .skill(createSkill(list.subList(28, 33)))
                .movement(createMovement(list.subList(33, 38)))
                .power(createPower(list.subList(38, 43)))
                .mentality(createMentality(list.subList(43, 49)))
                .defence(createDefance(list.subList(49, 52)))
                .golkepping(createGollkeping(list.subList(52, 58)))
                .club(club)
                .build();
        playerController.createPlayer(player);

    }

    private static Golkepping createGollkeping(List<String> subList) {
        return Golkepping.builder()
                .goalkeeping_diving(Integer.parseInt(subList.get(0)))
                .goalkeeping_handling(Integer.parseInt(subList.get(1)))
                .goalkeeping_kicking(Integer.parseInt(subList.get(2)))
                .goalkeeping_positioning(Integer.parseInt(subList.get(3)))
                .goalkeeping_reflexes(Integer.parseInt(subList.get(4)))
                .goalkeeping_speed(Integer.parseInt(subList.get(5)))
                .build();
    }

    private static Defending createDefance(List<String> subList) {

        return Defending.builder()
                .defending_marking_awareness(Integer.parseInt(subList.get(0)))
                .defending_standing_tackle(Integer.parseInt(subList.get(1)))
                .defending_sliding_tackle(Integer.parseInt(subList.get(2)))
                .build();

    }

    private static Mentality createMentality(List<String> subList) {
        //mentality_aggression	mentality_interceptions	mentality_positioning
        // mentality_vision	mentality_penalties	mentality_composure

        return Mentality.builder()
                .mentality_aggression(Integer.parseInt(subList.get(0)))
                .mentality_interceptions(Integer.parseInt(subList.get(1)))
                .mentality_positioning(Integer.parseInt(subList.get(2)))
                .mentality_vision(Integer.parseInt(subList.get(3)))
                .mentality_penalties(Integer.parseInt(subList.get(4)))
                .mentality_composure(Integer.parseInt(subList.get(5)))
                .build();


    }

    private static Power createPower(List<String> subList) {

        //power_shot_power	power_jumping	power_stamina	power_strength	power_long_shots

        return Power.builder()
                .power_shot_power(Integer.parseInt(subList.get(0)))
                .power_jumping(Integer.parseInt(subList.get(1)))
                .power_stamina(Integer.parseInt(subList.get(2)))
                .power_strength(Integer.parseInt(subList.get(3)))
                .power_long_shots(Integer.parseInt(subList.get(4)))
                .build();
    }

    private static Movement createMovement(List<String> subList) {
        //   movement_acceleration	movement_sprint_speed
        //   movement_agility	movement_reactions	movement_balance

        return Movement.builder()
                .movement_acceleration(Integer.parseInt(subList.get(0)))
                .movement_sprint_speed(Integer.parseInt(subList.get(1)))
                .movement_agility(Integer.parseInt(subList.get(2)))
                .movement_reactions(Integer.parseInt(subList.get(3)))
                .movement_balance(Integer.parseInt(subList.get(4)))
                .build();

    }

    private static Skill createSkill(List<String> subList) {
        //   skill_dribbling	skill_curve	skill_fk_accuracy
        //   skill_long_passing	skill_ball_control

        return Skill.builder()
                .skill_dribbling(Integer.parseInt(subList.get(0)))
                .skill_curve(Integer.parseInt(subList.get(1)))
                .skill_fk_accuracy(Integer.parseInt(subList.get(2)))
                .skill_long_passing(Integer.parseInt(subList.get(3)))
                .skill_ball_control(Integer.parseInt(subList.get(4)))
                .build();

    }

    private static Attacking createAttacking(List<String> subList) {
        //attacking_crossing	attacking_finishing	attacking_heading_accuracy
        // attacking_short_passing	attacking_volleys
        return Attacking.builder()
                .attacking_crossing(Integer.parseInt(subList.get(0)))
                .attacking_finishing(Integer.parseInt(subList.get(1)))
                .attacking_heading_accuracy(Integer.parseInt(subList.get(2)))
                .attacking_short_passing(Integer.parseInt(subList.get(3)))
                .attacking_volleys(Integer.parseInt(subList.get(4)))
                .build();
    }
}
