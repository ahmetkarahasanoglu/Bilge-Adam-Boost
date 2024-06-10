package com.ahmet.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@SuperBuilder
//@MappedSuperclass  // MongoDB'de buna ihtiyaç yok
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable { // serializable: UserProfileService'deki @Cacheable (redis) metotlarının verdiği hatayı ortadan kaldırmak için kullandık 'Serializable'ı

    private Long createDate;
    private Long updateDate;

}
