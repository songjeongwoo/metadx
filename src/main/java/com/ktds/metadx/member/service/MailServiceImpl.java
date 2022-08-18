package com.ktds.metadx.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ktds.metadx.member.dto.MemberDTO;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MailServiceImpl implements MailService{

    @Autowired
    private JavaMailSender emailSender;

    // 인증번호 생성
    @Override
    public String getTempPassword() {
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        return str;
    }

    // 메일 내용 작성
    @Override
    public String sendSimpleMessage(String email) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("sses536@gmail.com");

        log.info("입력한메일주소 : " + email);

        email = email.substring(0, email.length()-1);
        
        message.setTo(email);
        log.info("메일주소 : " + email);
        message.setSubject("인증메일 입니다.");

        String tempPassword = getTempPassword();

        message.setText("인증코드를 발급합니다. \n 인증코드 : " + tempPassword);

        emailSender.send(message);

        return tempPassword;
        
    }
    
}
