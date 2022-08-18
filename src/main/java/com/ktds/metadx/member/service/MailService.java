package com.ktds.metadx.member.service;

import org.springframework.stereotype.Service;

@Service
public interface MailService {

    public String getTempPassword();
    public String sendSimpleMessage(String email);
}
