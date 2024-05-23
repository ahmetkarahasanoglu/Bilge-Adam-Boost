package com.ahmet.service;

import com.ahmet.repository.AddressRepository;
import com.ahmet.repository.entity.Address;
import com.ahmet.utility.MyFactoryService;

public class AddressService extends MyFactoryService<AddressRepository, Address, Long> {

    public AddressService() {
        super(new AddressRepository());
    }

}
