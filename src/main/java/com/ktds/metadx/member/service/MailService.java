package com.ktds.metadx.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ktds.metadx.member.dto.MemberDTO;

@Service
public class MailService {
   
    @Autowired
    private JavaMailSender emailSender;


    // 인증번호 발급
    public String getTempPassword(){
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
    
    // 인증번호 메일 보내기
    public void sendSimpleMessage(MemberDTO member, HttpServletRequest request){
        
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("sses536@gmail.com");
        message.setTo(member.getEmail());
        message.setSubject("인증메일 입니다.");

        String tempPassword = getTempPassword();

        HttpSession session = request.getSession();
        session.setAttribute("tempPassword", tempPassword);

        message.setText("인증코드를 발급합니다. \n 인증코드 : " + tempPassword);

        emailSender.send(message);

    }

    // 내가 왜넣었을까(메일관련같은데 모르겠음)
    @Async
    public void sendEmail(SimpleMailMessage email){
        emailSender.send(email);
    }

}
