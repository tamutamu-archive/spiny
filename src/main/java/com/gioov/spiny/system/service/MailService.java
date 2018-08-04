package com.gioov.spiny.system.service;

import javax.mail.MessagingException;

/**
 * @author godcheese
 * @date 2018-07-04
 */
public interface MailService {

    void sendSimpleMailMessage(String to, String subject, String text);

    void sendMimeMailMessage(String to, String subject, String text, boolean html) throws MessagingException;

}
