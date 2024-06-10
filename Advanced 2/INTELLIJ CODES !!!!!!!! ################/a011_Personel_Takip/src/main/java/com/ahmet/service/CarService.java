package com.ahmet.service;

import com.ahmet.repository.CarRepository;
import com.ahmet.repository.entity.Car;
import com.ahmet.utility.MyFactoryService;

public class CarService extends MyFactoryService<CarRepository, Car, Long> {

    public CarService() {
        super(new CarRepository());
    }

}
