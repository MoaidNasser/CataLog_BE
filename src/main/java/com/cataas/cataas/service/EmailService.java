package com.cataas.cataas.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("moaidnasser19@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }

    public void sendActivationCode(String to, String code) {
        String subject = "Account Activation Code";
        String body = "Hello,\n\nYour activation code is: " + code +
                "\nThis code is valid for 15 minutes.\n\nBest regards,\nCats App Team";
        sendEmail(to, subject, body);
    }
}
