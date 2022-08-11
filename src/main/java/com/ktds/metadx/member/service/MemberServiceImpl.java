package com.ktds.metadx.member.service;

import javax.servlet.http.HttpSession;

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
        member.setPw(member.getPw());
        member.setUname(member.getUname());
        // member.setLockbool(false);
        // member.setAuth(false);
        member.setDid(member.getDid());
        member.setJno(member.getJno());
        member.setTid(member.getTid());
        memberMapper.saveMember(member);
    }

    @Override
    public MemberDTO loginMember(MemberDTO member) {
        log.info("==================");
        log.info(memberMapper.loginMember(member));
        return memberMapper.loginMember(member);
    }

}
