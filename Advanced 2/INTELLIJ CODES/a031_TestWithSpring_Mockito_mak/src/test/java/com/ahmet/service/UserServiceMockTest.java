package com.ahmet.service;

import com.ahmet.repository.IUserRepository;
import com.ahmet.repository.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.mockito.Mockito.*;

/**
 * UserService sınıfının testini yapıyoruz bu sayfada
 */

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceMockTest {

    @Autowired
    private UserService userService;

    /**
     * DİKKAT !!!!!
     * Kullanımlar önemli; ilk olarak üzerinde gerçek nesne ile
     * test yapılacak sınıfı belirliyoruz ve ona göre @InjectMocks
     * ile işaretliyoruz.
     * Devamında bir sınıfın içinde kullanmakta olduğu tüm diğer
     * sınıf implementasyonlarını (DI'ları) @Mock ile
     * işaretliyoruz ve sanallaştırmış oluyoruz.
     */
    @InjectMocks
    private UserService userServiceMock;
    @Mock
    private IUserRepository userRepository;

    // METHODS: ----

    @Test
    void saveTest() {
        User user = User.builder()
                .email("muhammet@gmail.com")
                .adres("Ankara")
                .ad("Muhammet")
                .telefon("0555 666 77 88")
                .build();
        User savedUser = userService.save(user);
        System.out.println(user.toString()); // user yerine savedUser yazmamız daha iyi değil mi?
        Assertions.assertTrue(user.getId()!=null); // savedUser için kontrol etmemiz gerekmez mi (user yerine)?
    }

    @Test
    void saveMockTest() {
        User user = User.builder()
                .email("muhammet@gmail.com")
                .adres("Ankara")
                .ad("Muhammet")
                .telefon("0555 666 77 88")
                .build();
        when(userRepository.findOptionalByAd(anyString()))
                .thenReturn(Optional.empty());
        when(userRepository.save(any()))
                .thenReturn(Optional.of(User.builder()
                        .id(125L)
                        .email("muhammet@gmail.com")
                        .adres("Ankara")
                        .ad("Muhammet")
                        .telefon("0555 666 77 88")
                        .build()));
        User savedUser = userServiceMock.save(user);
        System.out.println(user.toString());
        Assertions.assertTrue(savedUser.getId()!=null);
    }

}
