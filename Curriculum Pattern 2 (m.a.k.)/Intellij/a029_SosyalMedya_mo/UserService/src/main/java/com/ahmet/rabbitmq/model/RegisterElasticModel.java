package com.ahmet.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterElasticModel implements Serializable { // RegisterModel: bir Dto gibi kullanıyoruz. ||| Serializable: rabbitmq serileştirerek kullandığı için böyle yazıyoruz.

    private String id;
    private Long authId;
    private String username;
    private String email;

}
