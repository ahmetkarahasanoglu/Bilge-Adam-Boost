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

public class Power {

    int power_shot_power;
    int power_jumping;
    int power_stamina;
    int power_strength;
    int power_long_shots;


}
