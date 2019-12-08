package com.javainuse.service.impl;

import com.javainuse.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleMessage(String to, String subject, String text, Long id) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
        helper.setTo(to);
        helper.setFrom("immobilpfe@gmail.com");
        helper.setSubject(subject);
        mimeMessage.setContent("<h6>Veuillez cliquer ce <a href=\"http://localhost:8080/activate-account/" + id + "\" >lien </a> pour activer votre compte</h6>", "text/html");
        mailSender.send(mimeMessage);
    }

    @Override
    public void sendPasswordResetEmail(String to, String subject, String text, Long id) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
        helper.setTo(to);
        helper.setFrom("immobilpfe@gmail.com");
        helper.setSubject(subject);
        mimeMessage.setContent("<h6>Password reset email</h6>\n" +
                "<div>\n" +
                "    <a href=\"" + text + "\">Reset password link</a>\n" +
                "</div>", "text/html");
        mailSender.send(mimeMessage);
    }


    @Override
    public void sendExpriationEmail(String to, String subject, String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        mailSender.send(simpleMailMessage);
    }
}
