package com.ahmet.ilkSpringOrnek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Projeyi "start.spring.io" websitesi üzerinden
 * spring ayar tercihlerimizi girerek oluşturduk, indirdik.
 *
 * Browser'a "localhost:8080/hello" yazarak 'selam' metodumuzun
 * çalıştığını gördük.
 */
@SpringBootApplication
@RequestMapping("/")
@RestController
public class IlkSpringOrnekApplication {

	@GetMapping("/hello")
	public String selam() {
		return "<h1 style='color:red'> Selam </h1>";
	}

	public static void main(String[] args) {
		SpringApplication.run(IlkSpringOrnekApplication.class, args);
	}

}
