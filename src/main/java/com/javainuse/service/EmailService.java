package com.javainuse.service;

import javax.mail.MessagingException;

public interface EmailService {
    public void sendSimpleMessage(String to, String subject, String text, Long id) throws MessagingException;
    public void sendExpriationEmail(String to, String subject, String text);
    public void sendPasswordResetEmail(String to, String subject, String text, Long id) throws MessagingException;
}
