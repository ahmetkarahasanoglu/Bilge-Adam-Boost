package com.ahmet.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany(mappedBy = "club")
    List<Player> playerList;

    @ManyToOne(cascade = CascadeType.ALL)
    League league;
}
