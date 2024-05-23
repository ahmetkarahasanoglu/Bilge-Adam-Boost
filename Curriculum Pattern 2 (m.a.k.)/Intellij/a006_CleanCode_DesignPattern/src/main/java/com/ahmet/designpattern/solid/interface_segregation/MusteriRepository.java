package com.ahmet.designpattern.solid.interface_segregation;

import java.util.List;

public class MusteriRepository implements IMusteriRepository{
    @Override
    public void save(Object entity) {

    }

    @Override
    public void update(Object entity) {

    }

    @Override
    public void delete(Object entity) {

    }

    @Override
    public List<Object> findAll() {
        return null;
    }

    @Override
    public List<Object> findByMusteriNumber(Long mNumber) {
        return null;
    }
}
