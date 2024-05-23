package com.ahmet.service;

import com.ahmet.repository.entity.User;
import static org.junit.jupiter.api.Assertions.*; // tüm Assertions metotları bu sayfada kullanılabilir olur (metot başına 'Assertions.' yazmaya gerek olmadan direk metodu yazabiliriz)
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

// Not: h2 veritabanı kullanıyoruz; proje bazlı geçici database

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void saveTestForAcceptableUser() {
        User user = new User();
        user.setAd("Muhammet");
        user.setAdres("Ankara");
        userService.save(user); // Eğer kayıt başarılı olursa hata fırlatmaz ve user içinde id değeri olur.
        userService.getAll().forEach(x -> System.out.println(x));
        assertNotNull(user.getId());
    }

    /**
     * Eğer kullanıcı adı girilmemiş ise sistemin hata fırlatması
     * beklenir. Bir istisnanın fırlatılıp fırlatılmadığını
     * test eder.
     */
    @Test
    void saveTestForNullValue() {
        User user = new User();
        user.setAdres("Ankara");
        Exception exception = assertThrows(RuntimeException.class, () -> {
            userService.save(user);
        });
        assertEquals("Kullanıcı adı boş olamaz.", exception.getMessage());
    }

    @Test
    void saveTestForDuplicateUser() { // We're simulating to save a user that already exists in the system.
        User user = new User();
        user.setAd("Deniz");
        user.setAdres("Ankara");
        userService.save(user); // saving (the first time)
        Exception exception = assertThrows(RuntimeException.class, () ->{  // RuntimeException.class : this is the type of exception that we expect to be thrown.
            userService.save(user); // saving (the second time)
        });
        assertEquals("Bu isimde bir kullanıcı zaten var.", exception.getMessage()); // Comparing the obtained exception message with the original exception message from the code.
    }                                                                                                  // '--> If two messages are equal, the test will pass. If not equal, the test will fail.

    @Test
    void saveTestAddMultipleUsers() {
        User user = new User();
        user.setAd("Ahmet");
        user.setAdres("Ankara");
        userService.save(user);
        User user2 = new User();
        user2.setAd("Rasim");
        user2.setAdres("Ankara");
        userService.save(user2);
        User user3 = new User();
        user3.setAd("Nazmi");
        user3.setAdres("Ankara");
        userService.save(user3);
        userService.getAll().forEach(System.out::println);
        assertEquals(3, userService.getAll().size());
    }

    @Test
    void allTestCase() {
        int toplam = 3+1;
        assertEquals(4, toplam);
        assertTrue('a'<'b');
        assertTrue('a'<'b', ()-> "Bilgilendirme mesajı");
        Exception exception = assertThrows(RuntimeException.class, ()->{
            throw new RuntimeException("Hata fırlatıldı");
        });
        assertEquals("Hata fırlatıldı", exception.getMessage());
        assertTimeout(Duration.ofSeconds(1), ()->{  // we're stating "it must take time less than 1 second".
            Thread.sleep(997); // we're making it wait for a while; to test.
        });
        assertAll("Topluca işlem yapalım",
                ()-> assertEquals(4, "ayse".length()),
                ()-> assertTrue(2>0),
                ()-> assertNotEquals(5, 5+6)
        );
    }

}
