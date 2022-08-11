package com.ktds.metadx.member.mapper;

import java.util.List;
import java.util.Optional;

import com.ktds.metadx.member.dto.MemberDTO;

public interface MemberMapper {

    void saveMember(MemberDTO memberDTO); // 회원 가입

    void loginMember(MemberDTO memberDTO); // 로그인

    // public Optional<MemberDTO> findByEmail(String uname); // 이름으로 비밀번호 찾기

    // public Optional<MemberDTO> findByPw(String pw); // 패스워드 찾기

    // public void updateMember(MemberDTO member); // 회원 정보 수정

    // public void deleteMember(String email); // 회원 탈퇴

    // public Boolean existsByEmail(String email); // 이메일 중복 확인

}
