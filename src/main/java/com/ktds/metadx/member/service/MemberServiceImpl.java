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
    public void saveMember(MemberDTO member){
        member.setEmail(member.getEmail());
        member.setMpw(member.getMpw());
        member.setMname(member.getMname());
        // member.setLockbool(false);
        // member.setAuth(false);
        member.setDno(member.getDno());
        member.setJno(member.getJno());
        member.setTno(member.getTno());
        memberMapper.saveMember(member);
    }

    @Override
    public MemberDTO loginMember(MemberDTO member) {
        log.info("==================");
        log.info(memberMapper.loginMember(member));
        return memberMapper.loginMember(member);
    }

}
