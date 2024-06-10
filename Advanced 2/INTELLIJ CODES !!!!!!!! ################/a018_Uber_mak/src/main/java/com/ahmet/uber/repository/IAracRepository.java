package com.ahmet.uber.repository;

import com.ahmet.uber.repository.entity.Arac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAracRepository extends JpaRepository<Arac,Long> {
}
