package com.bilgeadam.repository.entity.embeded;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Golkepping {
    int goalkeeping_diving;
    int goalkeeping_handling;
    int goalkeeping_kicking;
    int goalkeeping_positioning;
    int goalkeeping_reflexes;
    int goalkeeping_speed;


}
