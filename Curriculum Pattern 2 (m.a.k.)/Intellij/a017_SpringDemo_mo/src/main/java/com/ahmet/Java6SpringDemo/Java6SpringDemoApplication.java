package com.ahmet.Java6SpringDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@SpringBootApplication
public class Java6SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java6SpringDemoApplication.class, args);
	}

}
