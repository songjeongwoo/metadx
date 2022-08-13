package com.ktds.metadx.member.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.ktds.metadx.member.dto.MemberDTO;

@Service
public interface MailService {

    public String getTempPassword();
    public String sendSimpleMessage(String email);
}
