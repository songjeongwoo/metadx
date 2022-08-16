package com.ktds.metadx.member.service;

import org.springframework.transaction.annotation.Transactional;

import com.ktds.metadx.member.dto.MemberDTO;

@Transactional
public interface MemberService {

    public boolean addMember(MemberDTO member);

    public MemberDTO loginMember(MemberDTO member);

    public int reset(MemberDTO member);

    public int deleteMember(MemberDTO member);

}