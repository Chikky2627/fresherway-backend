package com.fresherway.fresherway.controller;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestMailController {

    private final JavaMailSender mailSender;

    public TestMailController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @GetMapping("/test-mail")
    public String sendMail() {

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo("YOUR_OTHER_EMAIL@gmail.com"); // replace with another email
        mail.setSubject("Spring Boot Test");
        mail.setText("Email is working successfully!");

        mailSender.send(mail);

        return "Mail Sent Successfully";
    }
}