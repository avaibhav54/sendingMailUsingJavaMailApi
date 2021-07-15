package com.toDo.eMail_Sending;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Preparing to send message!" );
        
        String message="This message is to test Java Mail API";
        String subject="Check";
        String to="agarwalvaibhav041@gmail.com";
        String from="notvalid99999@gmail.com";
       // sendEmail(message,subject,to,from);
        sendAttatch(message, subject, to, from);
    }

	private static void sendEmail(String message, String subject, String to,  String from) {
		// TODO Auto-generated method stub
		//variable for gmail
		String host="smtp.gmail.com";
		//get  System properties
		Properties pro=	System.getProperties();
		System.out.println("properties"+pro);
		//setting important info to prooperties object
		
		pro.put("mail.smtp.host",host);
		pro.put("mail.smtp.port","465");
		pro.put("mail.smtp.ssl.enable","true");
		pro.put("mail.smtp.auth","true");
		Session session=		Session.getInstance(pro,new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("notvalid99999@gmail.com", "totallyinvalid");
			}
		});
		session.setDebug(true);
		MimeMessage mm=new MimeMessage(session);
		try {
			mm.setFrom(from);
			mm.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			mm.setSubject(subject);
			mm.setText(message);
			Transport.send(mm);
			System.out.println("hvgvgvhggh");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	private static void sendAttatch(String message, String subject, String to, String from) {
		// TODO Auto-generated method stub
		String host="smtp.gmail.com";
		//get  System properties
		Properties pro=	System.getProperties();
		System.out.println("properties"+pro);
		//setting important info to prooperties object
		
		pro.put("mail.smtp.host",host);
		pro.put("mail.smtp.port","465");
		pro.put("mail.smtp.ssl.enable","true");
		pro.put("mail.smtp.auth","true");
		Session session=		Session.getInstance(pro,new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("notvalid99999@gmail.com", "totallyinvalid");
			}
		});
		session.setDebug(true);
		MimeMessage mm=new MimeMessage(session);
		try {
			mm.setFrom(from);
			mm.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			mm.setSubject(subject);
			//file path
			String path="C:\\Users\\agarw\\Desktop\\dp.jpg";
			MimeMultipart multi=new MimeMultipart();
			MimeBodyPart textMime=new MimeBodyPart();
			MimeBodyPart fileMime=new MimeBodyPart();
			textMime.setText(message);
			File file=new File(path);
			fileMime.attachFile(file);
			multi.addBodyPart(textMime);
			multi.addBodyPart(fileMime);
			mm.setContent(multi);
			Transport.send(mm);
			System.out.println("Message Sent successfully");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
