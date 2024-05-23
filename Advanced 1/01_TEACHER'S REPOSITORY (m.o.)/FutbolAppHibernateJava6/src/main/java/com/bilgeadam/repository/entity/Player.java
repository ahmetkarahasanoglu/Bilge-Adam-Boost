package com.bilgeadam.repository.entity;

import com.bilgeadam.repository.entity.embeded.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@NamedQueries(
        {@NamedQuery(name = "findByPosition", query = "select p from Player as p where p.player_positions=:position"),
                @NamedQuery(name = "findByMid", query = "select p from Player as p where p.player_positions in " +
                        "('CM', 'CDM', 'CAM', 'RM', 'LM')")
        }
)
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String long_name;
    @Enumerated(EnumType.STRING)
    PlayerPositions player_positions;
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
    @ManyToOne()
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    Club club;

}
