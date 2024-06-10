package com.ahmet;

import com.ahmet.repository.entity.User;
import com.ahmet.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestExampleApplicationTests {

	@Autowired
	private UserService userService;

	/**
	 * 1. Test: Daha önce kayıt olmamış ve geçerli bir adı olan
	 * kullanıcı için test işlemi
	 */
	@Test
	void saveTestForAcceptableUser() {
		User user = new User();
		user.setAd("Muhammet");
		user.setAdres("Ankara");
		userService.save(user); // Eğer kayıt başarılı olursa hata fırlatmaz ve user içinde id değeri olur.
		userService.getAll().forEach(x -> System.out.println(x));
		Assertions.assertNotNull(user.getId());
	}

}
