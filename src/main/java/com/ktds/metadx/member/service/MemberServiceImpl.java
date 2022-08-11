package com.ktds.metadx.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ktds.metadx.member.dto.MemberDTO;
import com.ktds.metadx.member.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    
    private final MemberMapper memberMapper;

    // 회원가입
    @Override
    public void saveMember(MemberDTO member){
        member.setEmail(member.getEmail());
        member.setPw(member.getPw());
        member.setUname(member.getUname());
        member.setLockbool(false);
        member.setAuth(false);
        member.setDid(member.getDid());
        member.setJno(member.getJno());
        member.setTid(member.getTid());
        memberMapper.saveMember(member);
    }

    // 이메일 중복 확인
    // public Boolean emailAvailableCheck(String email){
    //     return !memberMapper.existsByEmail(email);
    // }

    // 비밀번호로 이메일 찾기
    // public String findByEmail(String pw){
    //     Optional<Member> result = memberMapper.findByPw(pw);
    //     if(result.isPresent() == true){
    //         return result.get().getEmail();
    //     }else{
    //         return "아이디를 찾지 못했습니다.";
    //     }
    // }   

}
