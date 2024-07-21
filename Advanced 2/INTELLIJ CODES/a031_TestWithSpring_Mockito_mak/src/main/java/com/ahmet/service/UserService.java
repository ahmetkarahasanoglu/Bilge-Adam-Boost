package com.ahmet.service;

import com.ahmet.repository.IUserRepository;
import com.ahmet.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public User save(User user) {
        Optional<User> optionalUser = userRepository.findOptionalByAd(user.getAd()); // userRepository'yi soyutlamamız lazım (Unit Test gereği); dışarıdan enjekte olan bir şey, onu test etmek istemiyoruz, bu metodu ilgilendirmiyor.
        if(optionalUser.isPresent()) {
            throw new RuntimeException("Bu isimde bir kullanıcı zaten var.");
        }else if(user.getAd()==null) {
            throw new RuntimeException("Kullanıcı adı boş olamaz.");
        }
        return userRepository.save(user); // userRepository'yi soyutlamamız lazım (Unit Test gereği); dışarıdan enjekte olan bir şey, onu test etmek istemiyoruz, bu metodu ilgilendirmiyor.
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

}
