package com.gioov.spiny.system.service;

import com.gioov.spiny.system.entity.EmailEntity;

import javax.mail.MessagingException;

/**
 * @author godcheese
 * @date 2018-07-04
 */
public interface EmailService {

    void addQueue(EmailEntity emailEntity);

    void send(EmailEntity emailEntity);

    void sendSimpleEmailMessage(String from, String to, String subject, String text);

    void sendMimeEmailMessage(String from, String to, String subject, String text, boolean html) throws MessagingException;

}
