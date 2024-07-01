package com.ahmet;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // Enables Feign clients in the microservice, allowing it to communicate with other microservices by sending and receiving data. In this case, it is used to send data to another microservice (to UserMikroServis)
public class AuthServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class);
    }
}