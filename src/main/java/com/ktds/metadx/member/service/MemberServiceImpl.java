package com.ktds.metadx.member.service;

import org.springframework.stereotype.Service;

import com.ktds.metadx.member.dto.MemberDTO;
import com.ktds.metadx.member.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;

    // 회원가입
    @Override
    public boolean addMember(MemberDTO memberDTO) {
        return memberMapper.saveMember(memberDTO) > 0;
    }

    @Override
    public MemberDTO loginMember(MemberDTO member) {
        log.info("==================");
        log.info(memberMapper.loginMember(member));
        return memberMapper.loginMember(member);
    }

}
