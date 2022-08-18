package com.ktds.metadx.member.mapper;


import com.ktds.metadx.member.dto.MemberDTO;

public interface MemberMapper {

    int saveMember(MemberDTO memberDTO); // 회원 가입

    MemberDTO loginMember(MemberDTO memberDTO); // 로그인

    int pwReset(MemberDTO memberDTO); // 패스워드 초기화

    int deleteMember(MemberDTO memberDTO); // 회원탈퇴

    MemberDTO findByEmail(String email); // 이메일로 유저 찾기
}
