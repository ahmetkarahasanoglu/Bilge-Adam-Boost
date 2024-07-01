package com.ahmet.repository;

import com.ahmet.repository.entity.Depo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepoRepository extends JpaRepository<Depo,Long> {
}
