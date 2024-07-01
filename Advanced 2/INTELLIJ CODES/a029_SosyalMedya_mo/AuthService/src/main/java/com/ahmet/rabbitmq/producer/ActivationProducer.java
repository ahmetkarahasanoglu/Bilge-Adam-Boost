package com.ahmet.rabbitmq.producer;

import com.ahmet.rabbitmq.model.ActivationModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivationProducer {

    @Value("${rabbitmq.exchange-auth}")
    private String directExchange;
    @Value("${rabbitmq.registermailkey}")
    private String registerMailBindingKey;

    private final RabbitTemplate rabbitTemplate;


    public void sendForActivation(ActivationModel model) {
        rabbitTemplate.convertAndSend(directExchange, registerMailBindingKey, model);
    }
}
