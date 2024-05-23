package com.ahmet.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbldepartment")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @OneToMany(mappedBy = "department") // means: look for the owning side of the relationship in the 'Person' entity, where the 'department' field is defined.
    List<Person> personList;

}
