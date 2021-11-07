package com.location.web.flight.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.location.web.flight.services.ReservationServiceImpl;

@Component
public class EmailUtil {
	@Value("${com.ayush.email.body}")
	private   String EMAIL_BODY;//= "Please find the Iternary Attached in the Attachment Area";
	@Value("${com.ayush.email.subject}")
	private   String EMAIL_SUBJECT;// = "Itinerary for your Flight";

	@Autowired
	private JavaMailSender send;
	
	private static final org.slf4j.Logger LOGGER=LoggerFactory.getLogger(EmailUtil.class);

	
	public void sendIternary(String to,String filePath)
	{
		LOGGER.info("Inside sendIternary()");
		MimeMessage mess = send.createMimeMessage();
		try {
			MimeMessageHelper messhelper = new MimeMessageHelper(mess,true); //if we passing attachment then we need to send this as true
			messhelper.setTo(to);
			messhelper.setSubject(EMAIL_SUBJECT);
			messhelper.setText(EMAIL_BODY);
			messhelper.addAttachment("Itneraary", new File(filePath));
			send.send(mess);
		} catch (MessagingException e) {
			LOGGER.error("Exception inside SendIternary"+e);
		//	e.printStackTrace();
		}  
 		
		
	}
	
}
