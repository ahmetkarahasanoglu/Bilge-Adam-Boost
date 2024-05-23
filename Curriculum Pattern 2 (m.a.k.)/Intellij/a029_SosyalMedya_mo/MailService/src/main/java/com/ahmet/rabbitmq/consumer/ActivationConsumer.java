package com.ahmet.rabbitmq.consumer;

import com.ahmet.rabbitmq.model.ActivationModel;
import com.ahmet.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivationConsumer {

    private final MailSenderService mailSenderService;

    @RabbitListener(queues = "${rabbitmq.registermailqueue}")
    public void sendActivationCode(ActivationModel model) {
        log.info("User {}", model.toString());
        mailSenderService.sendMail(model);
    }

}
