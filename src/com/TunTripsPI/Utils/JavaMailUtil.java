/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Utils;

import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Lotfi
 */
public class JavaMailUtil {
    public static void sendmail(String recipien) {
        Properties properties=new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        String accountemail="louizlouiz04@gmail.com";
        String password="92770929Lo";
        Session session =Session.getInstance(properties,new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
               
                return new javax.mail.PasswordAuthentication(accountemail, password); 
            }
           
});
        Message message = prepareMessage(session,accountemail,recipien);
        
        try {
            Transport.send(message);
            System.out.println("Message send Successfully");
        } catch (MessagingException ex) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }


        
    }

    private static Message prepareMessage(Session session, String accountemail, String recipien) {
        try {
            Message message=new MimeMessage(session);
            message.setFrom(new InternetAddress(accountemail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipien));
            message.setSubject("Activer votre compte TunTrips ... ");
            message.setText("Hey Our tourist, activate you account now .. ");
            
          
            return message ; 
        } catch (MessagingException ex) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; 
    }
    
}
