package com.ahmet.Monolitik.repository;

import com.ahmet.Monolitik.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
    User findByEmail(String email);
    Optional<User> findByUsernameAndPassword(String username, String password);
    Optional<User> findOptionalByEmailAndPassword(String email, String password);

}
