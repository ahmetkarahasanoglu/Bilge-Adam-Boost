package com.ahmet.Java6MovieApp.service;

import com.ahmet.Java6MovieApp.dto.request.UserLoginRequestDto;
import com.ahmet.Java6MovieApp.dto.request.UserRegisterRequestDto;
import com.ahmet.Java6MovieApp.dto.response.UserLoginResponseDto;
import com.ahmet.Java6MovieApp.mapper.IUserMapper;
import com.ahmet.Java6MovieApp.repository.IUserRepository;
import com.ahmet.Java6MovieApp.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IServiceCrud<User> {

    @Autowired
    private IUserRepository userRepository;

//    public UserService(IUserRepository repository) { // '@Autowired' kullandığımız için (yukarda), bu constructor'a gerek yok.
//        super(repository);
//        this.userRepository = repository;
//    }

    public User createUser(String name, String surname, String password, String email) {
        User user = User.builder()
                .name(name)
                .surname(surname)
                .password(password)
                .email(email)
                .build();
        return userRepository.save(user);
    }

    public User saveDto(UserRegisterRequestDto dto) {
        User user = User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
        return userRepository.save(user);
    }

    public User saveDto2(UserRegisterRequestDto dto) {
        return userRepository.save(IUserMapper.INSTANCE.toUser(dto));
    }


    public List<User> findAllByOrderByName() {
        return userRepository.findAllByOrderByName();
    }

    public List<User> findByNameContainingIgnoreCase(String value) {
        return userRepository.findByNameContainingIgnoreCase(value);
    }

    public List<User> findByEmailContainingIgnoreCase(String value) {
        return userRepository.findByEmailContainingIgnoreCase(value);
    }

    public List<User> findByEmailEndingWith(String value) {
        return userRepository.findByEmailEndingWith(value);
    }

    public UserLoginResponseDto login(UserLoginRequestDto dto) {
        Optional<User> user = userRepository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if(user.isPresent()) {
            return IUserMapper.INSTANCE.toUserLoginResponseDto(user.get());
        } else {
            throw new RuntimeException("Böyle bir kullanıcı bulunamadı.");
        }
    }

    public List<User> passwordLongerThan(int value) {
        return userRepository.passwordLongerThan(value);
    }
    public List<User> passwordLongerThan2(int value) {
        return userRepository.passwordLongerThan2(value);
    }
    public List<User> passwordLongerThan3(int value) {
        return userRepository.passwordLongerThan3(value);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Iterable<User> saveAll(Iterable<User> t) {
        return userRepository.saveAll(t);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
