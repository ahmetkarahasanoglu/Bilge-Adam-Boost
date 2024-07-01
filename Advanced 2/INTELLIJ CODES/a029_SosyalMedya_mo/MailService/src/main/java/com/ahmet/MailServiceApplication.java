package com.ahmet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class MailServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailServiceApplication.class);
    }


    // DENEME AMAÇLI KOD:
//    private final JavaMailSender javaMailSender;
//
//    public MailServiceApplication(JavaMailSender javaMailSender) {
//        this.javaMailSender = javaMailSender;
//    }
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void sendMail() {
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setFrom("${Mail-SosyalMedyaApp-Intellij-B.AdamBoost}");
//        mailMessage.setTo("ahmettemp2@gmail.com");
//        mailMessage.setSubject("AKTİVASYON KODUNUZ");
//        mailMessage.setText("asdf dfgsgg gfgsd dfgfg");
//        javaMailSender.send(mailMessage);
//    }






}