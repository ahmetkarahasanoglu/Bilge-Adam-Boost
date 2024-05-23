package com.ahmet.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder // SuperBuilder'ı buraya yazıyoruz, alt sınıflara da yazıyoruz.
@MappedSuperclass // Diğer sınıflar bu sınıftan miras aldığı için böyle yazdık.
public class BaseEntity {
    Long createat;
    Long updateat;
    @Enumerated(EnumType.STRING)
    EntityState state;
}
