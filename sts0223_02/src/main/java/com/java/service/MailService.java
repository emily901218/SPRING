package com.java.service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	JavaMailSender mailSender;//pom.xml <!-- -boot-starter-mail -->설정해서 가능!!
	
	//비밀번호 생성
	public String getCreateKey() {
		
		String pwCode="";
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', 
				'8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 
				'W', 'X', 'Y', 'Z' };
		
		int idx = 0;
		for(int i=0;i<10;i++) {
			idx =(int)(Math.random()*charSet.length);//0-35
			pwCode += charSet[idx];
		}

		return pwCode;
	}//비밀번호
	
	//이메일 발송 - text형태 발송
	@Async//비동기식
	public String mailSend(String userEmail,String userName) {
		SimpleMailMessage message = new SimpleMailMessage();//오로지 텍스트 형태로만 보낼 수 있다.
		String pwCode = getCreateKey();//임시 비밀번호 생성
		
		System.out.println("이메일 인증 비밀번호 : "+pwCode);
		
		//메일 발송정보
		String fromEmail ="raywon90@gmail.com";
		String subject  = userName +"님의 회원가입 이메일인증 임시번호 안내";
		String sendTxt ="안녕하세요 .회원가입 이메일 인증 임시번호를 안내관련 이메일입니다. \n"+
							"["+userName+"]님의 임시 인증 비밀번호 : "+pwCode+" 입니다.\n";
		//		안녕하세요 회원가입 이메일 인증 임시번호 안내관련 이메일입니다.
		//		홍길동 님 임시 인증 비밀 번호 : dnfkjldsg4dsg57sd
		//메일 발송 정보를 입력
		message.setTo(userEmail);  //발송할 대상 이메일주소
		message.setFrom(fromEmail);//보내는 사람의 이메일주소
		message.setSubject(subject);//이메일 발송 제목
		message.setText(sendTxt);   //이메일 내용	
		mailSender.send(message);   //이메일 발송
		
		//출력
		System.out.println("이메일 발송 완료");
		return pwCode;
		
	}//이메일 발송
	
	
	//이메일 발송 - html형태 발송
	@Async//비동기식
	public String mailSend2(String userEmail,String userName) {
		
		//SimpleMailMessage message = new SimpleMailMessage();//오로지 텍스트 형태로만 보낼 수 있다.
		MimeMessage message = mailSender.createMimeMessage();
		
		String pwCode = getCreateKey();//임시 비밀번호 생성
		
		System.out.println("이메일 인증 비밀번호 : "+pwCode);
		
		//메일 발송정보
		String fromEmail ="raywon90@gmail.com";
		String subject  = userName +"님의 회원가입 이메일인증 임시번호 안내";

		String htmlTxt ="<img src='https://ssl.pstatic.net/melona/libs/1437/1437058/147858123ee75cfd4c4f_20230222114509810.jpg'><br>" 
				+"<h3>안녕하세요 .회원가입 이메일 인증 임시번호를 안내관련 이메일입니다.<br>"+
				"["+userName+"]님의 임시 인증 비밀번호 : <span style='color:red; font-weight:bold'>"+pwCode+"</span> 입니다.</h3><br>";
		
		try {
			message.setSubject(subject);//이메일 발송 제목
			message.setFrom(new InternetAddress(fromEmail));//보내는 사람의 이메일주소
			message.setText(htmlTxt,"utf-8","html");   //이메일 내용	
			message.addRecipient(RecipientType.TO, new InternetAddress(userEmail));//발송할 대상 이메일주소
			mailSender.send(message);   //이메일 발송
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//출력
		System.out.println("이메일 발송 완료");
		return pwCode;
		
	}//이메일 발송
	
	
	
}
