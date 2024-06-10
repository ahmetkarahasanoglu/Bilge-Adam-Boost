package com.ahmet.repository.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;


@Embeddable
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    Long createat;
    Long updateat;
    Integer state;
}
