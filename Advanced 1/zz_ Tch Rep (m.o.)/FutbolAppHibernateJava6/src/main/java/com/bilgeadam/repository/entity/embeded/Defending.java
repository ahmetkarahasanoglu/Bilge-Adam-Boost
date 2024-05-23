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

public class Defending {

    int defending_marking_awareness;

    int defending_standing_tackle = 0;

    int defending_sliding_tackle = 0;


}
