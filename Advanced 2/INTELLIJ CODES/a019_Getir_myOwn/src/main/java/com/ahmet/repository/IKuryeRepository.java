package com.ahmet.repository;

import com.ahmet.repository.entity.Kurye;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKuryeRepository extends JpaRepository<Kurye,Long> {
}
