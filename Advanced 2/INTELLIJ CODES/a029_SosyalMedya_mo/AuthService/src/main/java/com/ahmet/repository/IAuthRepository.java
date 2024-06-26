package com.ahmet.repository;

import com.ahmet.repository.entity.Auth;
import com.ahmet.repository.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAuthRepository extends JpaRepository<Auth,Long> {

    Optional<Auth> findOptionalByUsernameAndPassword(String username, String password);

    Optional<Auth> findById(Long id);

    List<Auth> findAllByRole(ERole role);
}
