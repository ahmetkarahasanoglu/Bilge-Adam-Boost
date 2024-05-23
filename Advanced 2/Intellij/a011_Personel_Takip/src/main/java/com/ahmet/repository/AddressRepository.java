package com.ahmet.repository;

import com.ahmet.repository.entity.Address;
import com.ahmet.utility.MyFactoryRepository;

public class AddressRepository extends MyFactoryRepository<Address,Long> {

    public AddressRepository() {
        super(new Address());
    }
}
