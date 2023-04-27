package com.iu.base.util;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MailManager {
	
	@Value("${spring.mail.username}")
	private String sender;

	@Autowired
	private JavaMailSender javaMailSender; 
	
	public void send(String email, String title, String text) throws Exception {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		mimeMessage.setFrom(sender);
		mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(email));
		mimeMessage.setSubject(title);
		mimeMessage.setText(text);
		javaMailSender.send(mimeMessage);
		
		//HTML 태그를 무시하고 그대로 Text로 전송
//		// SimpleMailMessage (단순 텍스트 구성 메일 메시지 생성할 때 이용)
//		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//		//발신자 설정
//		simpleMailMessage.setFrom(sender);
//		//수신자 설정
//		simpleMailMessage.setTo(email);
//		// 메일 제목
//		simpleMailMessage.setSubject(title);
//		// 메일 내용
//		simpleMailMessage.setText(text);
//		// 메일 발송
//		javaMailSender.send(simpleMailMessage);
	}

}
