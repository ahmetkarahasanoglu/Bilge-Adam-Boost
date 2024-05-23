package com.ahmet.repository;

import com.ahmet.repository.entity.Person;
import com.ahmet.utility.MyFactoryRepository;

public class PersonRepository extends MyFactoryRepository<Person, Long> {

    public PersonRepository() {
        super(new Person());
    }

}
