package com.ahmet.service;

import com.ahmet.repository.PersonRepository;
import com.ahmet.repository.entity.Person;
import com.ahmet.utility.MyFactoryService;

public class PersonelService extends MyFactoryService<PersonRepository, Person, Long> {

    public PersonelService() {
        super(new PersonRepository());
    }

}
