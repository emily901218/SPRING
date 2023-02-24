package com.java.service;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService{

	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	HttpSession session;
	
	
	@Async
	@Override
	public String getCreateKey() {
		//랜덤숫자 10개 생성
		String pwCode ="";
		char[] charSet = {'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T',
				'U','V','W','X','Y','Z'};
		int idx =0;
		for (int i=0;i<10;i++) {
			idx =(int)(Math.random()*36);//0-35
			pwCode += charSet[idx];
			
		}
		System.out.println("이메일 비밀번호 생성 : "+pwCode);
		//session.setAttribute("sessionPwCode", pwCode);
		return pwCode;
	}//getCreateKey

	@Override//텍스트 이메일 발송
	public String mailSend(String userEmail, String userName) {
		//이메일 text,html ,파일첨부
		SimpleMailMessage message = new SimpleMailMessage();
		String pwCode = getCreateKey();//비밀번호 가져오기
		//메일 발송
		String fromMailAddress = "admin@naver.com";
		String subject = "[안내]"+userName+"님 회원가입 이메일인증 비밀번호 발송안내";
		String sendTxt = "안녕하세요. 회원가입에 필요한 이메일인증 임시번호를 발송드립니다.\n"+
						 "["+userName+"]님 이메일 인증 비밀번호 : "+pwCode+" 입니다.\n";
		
			message.setFrom(fromMailAddress);//보내는 사람 이메일
			message.setTo(userEmail);		 //받는 사람 이메일
			message.setSubject(subject);     //이메일 제목
			message.setText(sendTxt);        //이메일 내용
			mailSender.send(message);        //메일 발송
		
		System.out.println("[ 발송 ] 이메일이 발송되었습니다." );
		//session.setAttribute("sessionPwCode", pwCode);
		return pwCode;
	}//mailSend
	
	@Async//html 포함 이메일 발송
	public String mailSend2(String userEmail, String userName) {
		//이메일 html ,파일첨부
		//SimpleMailMessage message = new SimpleMailMessage();
		MimeMessage message = mailSender.createMimeMessage();
		String pwCode = getCreateKey();//비밀번호 가져오기
		//메일 발송
		String fromMailAddress = "admin@naver.com";
		String subject = "[안내]"+userName+"님 회원가입 이메일인증 비밀번호 발송안내";
		String sendTxt = getSendTxt(userName);
		try {
			message.setFrom(new InternetAddress(fromMailAddress));//보내는 사람 이메일
			message.addRecipient(RecipientType.TO, new InternetAddress(userEmail));
			//message.setTo(userEmail);		 //받는 사람 이메일
			message.setSubject(subject);     //이메일 제목
			message.setText(sendTxt,"utf-8","html");        //이메일 내용
			mailSender.send(message);        //메일 발송
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//session.setAttribute("sessionPwCode", pwCode);
		System.out.println("[ 발송 ] 이메일이 발송되었습니다." );
		return pwCode;
	}//mailSend2
	
	
	@Async//파일 포함 이메일 발송
	public String mailSend3(String userEmail, String userName) {
		//이메일 html ,파일첨부
		//SimpleMailMessage message = new SimpleMailMessage();
		MimeMessage message = mailSender.createMimeMessage();
		String pwCode = getCreateKey();//비밀번호 가져오기
		//메일 발송
		String fromMailAddress = "admin@naver.com";
		String subject = "[안내]"+userName+"님 회원가입 이메일인증 비밀번호 발송안내";
		String sendTxt = getSendTxt(userName);
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true,"utf-8");
			
			messageHelper.setFrom(fromMailAddress);  //보내는 사람 이메일
			messageHelper.setSubject(subject);       //이메일 제목
			messageHelper.setText(sendTxt,true);     //이메일 내용
			messageHelper.setTo(new InternetAddress(userEmail,userName,"utf-8"));
			//파일첨부
			DataSource dataSource = new FileDataSource("C:\\properties.txt"); 
			messageHelper.addAttachment(MimeUtility.encodeText("properties.txt","utf-8","B"),dataSource);//B는 binary
			mailSender.send(message);                //메일 발송
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//session.setAttribute("sessionPwCode", pwCode);
		System.out.println("[ 발송 ] 이메일이 발송되었습니다." );
		return pwCode;
	}//mailSend3
	
	public String getSendTxt(String userName) {
		String sendTxt = "<html>\r\n"
				+ "	<head>\r\n"
				+ "		<meta charset='UTF-8'>\r\n"
				+ "		<title>메일 보내기</title>\r\n"
				+ "		\r\n"
				+ "	</head>\r\n"
				+ "	<body>\r\n"
				+ "		<table style ='width:750px' >\r\n"
				+ "			<tr style ='width:135px' >\r\n"
				+ "				<td><img style ='width:750px'  src='https://ssl.pstatic.net/melona/libs/1436/1436165/6677efdd68dc624ee852_20230223213601865.jpg'></td>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "				<td style='text-align:center'>\r\n"
				+ "					<h2 >["+userName+"님] 강력추천 !!아식스 여성 레깅스 특가</h2>\r\n"
				+ "				</td>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "				<td>옆선 배색 디자인 포인트로 날씬한 다리라인을 연출 할 수 있는 여성 트레이닝 그래픽 타이츠입니다.	</td>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "				<td>▶ 글 싣는 순서 ①美무능, 中묵인, 푸틴이 지른 우크라전 1년…전세계 고통 가중 ②우크라이나 전쟁 후 펼쳐질 '新 국제질서'의 모습은? ③전쟁이 쏘아올린 에너지난·식량 위기, 세계 경제를 흔들다 (계속) \"향후 한국 ..</td>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "				<td>경향신문이 권인숙 더불어민주당 의원실에서 23일 입수한 박성민 전 서울경찰청 공공안녕정보외사부장(경무관)과 김진호 전 용산서 정보과장(경정)의 추가 공소장에서 서울서부지검은 “경찰이 사고에 대한 책임이 없다는 취지의 여론 형성을 시도했다”고 적시했다. 박 경무관과 김 경정은 총 4건의 정보보고서 삭제를 지시한 혐의를 받는다.</td>\r\n"
				+ "			</tr>\r\n"
				+ "		\r\n"
				+ "		\r\n"
				+ "		</table>\r\n"
				+ "	\r\n"
				+ "	\r\n"
				+ "	</body>\r\n"
				+ "</html>";
		return sendTxt; 
				
	}

	




}
