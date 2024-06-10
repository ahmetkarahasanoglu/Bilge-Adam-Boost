package com.ahmet.repository.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tblcar")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String marka;

    @OneToOne(mappedBy = "car") // means: look for the owning side of the relationship in the 'Person' entity, where the 'car' field is defined.
    Person person; // 1'e 1 ilişki. 'Person' sınıfının içine de 'Car car' yazdık.

}
