package com.ahmet.service;

import com.ahmet.rabbitmq.model.ActivationModel;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderService {

    private final JavaMailSender javaMailSender;


    public void sendMail(ActivationModel model) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("${MailSosyalMedyaAppIntellijBAdamBoost}");
        mailMessage.setTo(model.getEmail());
        mailMessage.setSubject("AKTİVASYON KODU");
        mailMessage.setText("Sayın " + model.getUsername() + " isimli kullanıcımız, " +
                "aktivasyon kodunuz: " + model.getActivationCode());
        javaMailSender.send(mailMessage);
    }

}
