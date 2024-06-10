package com.ahmet.Monolitik.service;

import com.ahmet.Monolitik.repository.IUserRepository;
import com.ahmet.Monolitik.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository repository;


    public void save(String username, String email, String password) {
        repository.save(User.builder()
                .username(username)
                .email(email)
                .password(password)
                .build());
    }

    public boolean isUser(String email, String password) {
        Optional<User> userOptional = repository.findOptionalByEmailAndPassword(email, password);
        return userOptional.isPresent();
    }

}
