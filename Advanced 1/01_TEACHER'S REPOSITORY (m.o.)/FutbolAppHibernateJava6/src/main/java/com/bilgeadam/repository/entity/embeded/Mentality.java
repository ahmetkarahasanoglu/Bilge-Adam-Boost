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
public class Mentality {

    int mentality_aggression;
    int mentality_interceptions;
    int mentality_positioning;
    int mentality_vision;
    int mentality_penalties;
    int mentality_composure;


}
