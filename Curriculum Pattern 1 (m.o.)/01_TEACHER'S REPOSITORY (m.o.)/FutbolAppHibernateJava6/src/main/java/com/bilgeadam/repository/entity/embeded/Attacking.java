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
public class Attacking {

    private int attacking_crossing;

    private int attacking_finishing;

    private int attacking_heading_accuracy;

    private int attacking_short_passing;

    private int attacking_volleys;

}
