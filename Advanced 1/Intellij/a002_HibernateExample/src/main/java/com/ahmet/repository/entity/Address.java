package com.ahmet.repository.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * sokak ismi
 * şehir ismi
 * ülke ismi
 */
@Embeddable
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String sokak;
    private String sehir;
    private String ulke;
}
