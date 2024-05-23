package com.ahmet.rabbitmq.consumer;

import com.ahmet.mapper.IUserMapper;
import com.ahmet.rabbitmq.model.RegisterModel;
import com.ahmet.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j // (console'da "info" log'u atması için kullanılır (ayağa kaldırdığımızda çıkan yazılarda). - çok önemli değil)
public class RegisterConsumer {

    private final UserProfileService userProfileService;

    @RabbitListener(queues = "${rabbitmq.queueRegister}") // (configServer'dan çekiyoruz - user-service-application.yml'den)
    public void newUserCreate(RegisterModel model) {
        log.info("User {}", model.toString()); // (console'da info log'u atması için (slf4j - lombok)
        userProfileService.createUserWithRabbitMq(model);

    }

}
