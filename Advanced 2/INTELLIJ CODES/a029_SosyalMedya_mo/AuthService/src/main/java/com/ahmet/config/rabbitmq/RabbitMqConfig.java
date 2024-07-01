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

    @Value("${rabbitmq.exchange-auth}") // configServer'dan değer çekiyoruz (auth-service-application.yml'den)
    private String exchange; // (aşağıdaki blokta farklı bir exchange tanımlamamıza gerek yok, aynı exchange'i kullanacaz)
    @Value("${rabbitmq.queueRegister}")
    private String queueNameRegister;
    @Value("${rabbitmq.registerkey}")
    private String registerBindingKey;

    @Value("${rabbitmq.registermailkey}")
    private String registerMailBindingKey; // (aktivasyon kodunu mail atma için)
    @Value("${rabbitmq.registermailqueue}")
    private String registerMailQueue; // (aktivasyon kodunu mail atma için)

    @Bean
    DirectExchange exchangeAuth() {
        return new DirectExchange(exchange);
    }
    @Bean
    Queue registerQueue() {
        return new Queue(queueNameRegister);
    }
    @Bean
    Queue registerMailQueue() {
        return new Queue(registerMailQueue);
    }

    @Bean
    public Binding bindingRegister(final Queue registerQueue, final DirectExchange exchangeAuth) {
        return BindingBuilder.bind(registerQueue).to(exchangeAuth).with(registerBindingKey);
    }
    @Bean
    public Binding bindingRegisterMail(final Queue registerMailQueue, final DirectExchange exchangeAuth) { // (aktivasyon kodunu mail atma için)
        return BindingBuilder.bind(registerMailQueue).to(exchangeAuth).with(registerMailBindingKey);
    }


}
