package com.ahmet.repository.entity;

import java.util.List;
import java.util.Optional;

public interface ICrud<T> {

//    void save(T t);
//    void update(T t);
//    void delete(Long id);
    Optional<T> findById(Long id);
    List<T> findAll();

}
