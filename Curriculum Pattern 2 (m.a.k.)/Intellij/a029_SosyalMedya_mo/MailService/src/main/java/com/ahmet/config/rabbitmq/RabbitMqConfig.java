package com.ahmet.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.registermailqueue}")
    private String registerMailQueue; // (aktivasyon kodunu mail atma için)

    @Bean
    Queue registerMailQueue() {
        return new Queue(registerMailQueue);
    }

}
