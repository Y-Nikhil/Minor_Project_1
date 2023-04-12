package com.ashokit.utility;

import java.io.File; 

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SendEmail {
	
	@Autowired
	private JavaMailSender emailSender;

	public boolean sendEmail(String subject, String body, String to, File f) throws Exception {
		
		try {
			MimeMessage message= emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			
			helper.setFrom("yarranarayana2000@gmail.com");
			helper.setSubject(subject);
			helper.setText(body, true);
			helper.setTo(to);
			helper.addAttachment("Insurance Policy-Info", f);
			emailSender.send(message);
			System.out.println("Email send with Attachment successsfull...");
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return true;
	}
}
