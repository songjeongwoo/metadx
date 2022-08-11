package com.ktds.metadx.member.service;

import javax.servlet.http.HttpSession;

import org.springframework.transaction.annotation.Transactional;

import com.ktds.metadx.member.dto.MemberDTO;

@Transactional
public interface MemberService {

    void saveMember(MemberDTO member);

    public MemberDTO loginMember(MemberDTO member);
    public void logout(HttpSession session);

}