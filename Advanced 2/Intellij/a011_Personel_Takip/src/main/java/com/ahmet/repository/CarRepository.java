package com.ahmet.repository;

import com.ahmet.repository.entity.Car;
import com.ahmet.utility.MyFactoryRepository;

public class CarRepository extends MyFactoryRepository<Car,Long> {

    public CarRepository() {
        super(new Car());
    }

}
