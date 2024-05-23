package com.ahmet.repository.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String long_name;
    @Enumerated(EnumType.STRING)
    PlayerPositions playerPositions;
    int overall;
    int potential;
    double value_eur;
    double wage_eur;
    int age;
    double height_cm;
    double weight_kg;
    String club_position;
    int club_jersey_number;
    String club_contract_valid_until;
    String nationality_name;
    String preferred_foot;
    int pace;
    int shooting;
    int passing;
    int dribbling;
    int defending;
    int physic;
    @Embedded
    @Builder.Default
    Attacking attacking = Attacking.builder().build();
    @Embedded
    @Builder.Default
    Defending defence = Defending.builder().build();
    @Embedded
    @Builder.Default
    Golkepping golkepping = Golkepping.builder().build();
    @Embedded
    @Builder.Default
    Mentality mentality = Mentality.builder().build();
    @Embedded
    @Builder.Default
    Movement movement = Movement.builder().build();
    @Embedded
    @Builder.Default
    Power power = Power.builder().build();
    @Embedded
    @Builder.Default
    Skill skill = Skill.builder().build();
    @ManyToOne(cascade = CascadeType.ALL)
    Club club;

}
