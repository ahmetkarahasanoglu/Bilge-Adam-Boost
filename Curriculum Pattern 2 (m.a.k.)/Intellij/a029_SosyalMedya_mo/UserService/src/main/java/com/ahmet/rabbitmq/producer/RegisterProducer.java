package com.ahmet.rabbitmq.producer;

import com.ahmet.rabbitmq.model.RegisterElasticModel;
import com.ahmet.rabbitmq.model.RegisterModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterProducer {

    @Value("${rabbitmq.exchange-user}") // config server'dan değer çekiyoruz - user-service-application.yml'dan
    private String directExchange;
    @Value("${rabbitmq.elasticregisterkey}")
    private String registerBindingKey;


    private final RabbitTemplate rabbitTemplate;

    public void sendNewUser(RegisterElasticModel model) {
        rabbitTemplate.convertAndSend(directExchange, registerBindingKey, model);
    }



}
