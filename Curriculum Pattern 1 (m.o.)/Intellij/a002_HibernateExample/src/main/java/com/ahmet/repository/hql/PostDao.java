package com.ahmet.repository.hql;

import com.ahmet.repository.entity.ICrud;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;

public class PostDao implements ICrud {

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List findAll() {
        return null;
    }

    public List<Tuple> postCountOfEachUser() {
        String hql = "select postcount from User";
        return null;
    }
}
