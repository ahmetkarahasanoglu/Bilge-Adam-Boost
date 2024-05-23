package com.ahmet.repository.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Name {
    private String firstname;
    private String middlename;
    private String surname;
}
