package com.ahmet.uber.repository;

import com.ahmet.uber.repository.entity.Kiralama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKiralamaRepository extends JpaRepository<Kiralama,Long> {
}
