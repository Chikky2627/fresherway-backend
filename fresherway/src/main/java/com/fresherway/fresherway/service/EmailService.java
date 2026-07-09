package com.fresherway.fresherway.service;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    public void sendVerificationEmail(String email, String token) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setSubject("Verify Your FresherWay Account");

        message.setText(
            "Click the link below to verify your account:\n\n" +
            "http://localhost:8086/api/auth/verify?token=" + token
        );

        mailSender.send(message);
    }
}