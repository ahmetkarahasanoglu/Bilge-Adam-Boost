package com.ahmet.service;

import com.ahmet.dto.request.LoginRequestDto;
import com.ahmet.dto.request.RegisterRequestDto;
import com.ahmet.dto.response.LoginResponseDto;
import com.ahmet.dto.response.RegisterResponseDto;
import com.ahmet.mapper.IUserMapper;
import com.ahmet.repository.IUserRepository;
import com.ahmet.repository.entity.User;
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

    public User saveDto(RegisterRequestDto dto) {
        User user = User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
        return userRepository.save(user);
    }

    public User saveDto2(RegisterRequestDto dto) {
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

    public List<User> passwordLongerThan(int value) {
        return userRepository.passwordLongerThan(value);
    }
    public List<User> passwordLongerThan2(int value) {
        return userRepository.passwordLongerThan2(value);
    }
    public List<User> passwordLongerThan3(int value) {
        return userRepository.passwordLongerThan3(value);
    }

    public LoginResponseDto login(LoginRequestDto dto) {
        Optional<User> user=userRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if (user.isEmpty()){
            throw new RuntimeException("Kullanici adi veya Sifre Hatali");
        }
        return IUserMapper.INSTANCE.toLoginResponseDto(user.get());
    }

    public User register(RegisterRequestDto dto) {
        if(userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Bu email daha önce kaydedilmiştir.");
        }
        if(!dto.getPassword().equals(dto.getRePassword())) {
            throw new RuntimeException("Girdiğiniz şifreler uyuşmuyor.");
        }
        User user = IUserMapper.INSTANCE.toUser(dto);
        return userRepository.save(user);

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
