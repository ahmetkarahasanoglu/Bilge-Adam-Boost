package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@SuperBuilder
public class Features {
    private int attacking_crossing;
    private int attacking_finishing;
    private int attacking_heading_accuracy;
    private int attacking_short_passing;
    private int attacking_volleys;
    int defending_marking_awareness;
    int defending_standing_tackle;
    int defending_sliding_tackle;
    int goalkeeping_diving;
    int goalkeeping_handling;
    int goalkeeping_kicking;
    int goalkeeping_positioning;
    int goalkeeping_reflexes;
    int goalkeeping_speed;
    int mentality_aggression;
    int mentality_interceptions;
    int mentality_positioning;
    int mentality_vision;
    int mentality_penalties;
    int mentality_composure;
    private int movement_acceleration;
    private int movement_sprint_speed;
    private int movement_agility;
    private int movement_reactions;
    private int movement_balance;
    int power_shot_power;
    int power_jumping;
    int power_stamina;
    int power_strength;
    int power_long_shots;
    private int skill_dribbling;
    private int skill_curve;
    private int skill_fk_accuracy;
    private int skill_long_passing;
    private int skill_ball_control;
}
