package com.ahmet.rabbitmq.producer;

import com.ahmet.rabbitmq.model.ActivationModel;
import com.ahmet.rabbitmq.model.RegisterModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterProducer {

    @Value("${rabbitmq.exchange-auth}") // config server'dan değer çekiyoruz - auth-service-application.yml'dan
    private String directExchange;
    @Value("${rabbitmq.registerkey}")
    private String registerBindingKey;


    private final RabbitTemplate rabbitTemplate;

    public void sendNewUser(RegisterModel model) { // AuthMikro'dan UserMikro'ya veri gönderimi (kuyruk yapısıyla)
        rabbitTemplate.convertAndSend(directExchange, registerBindingKey, model);
    }



}
