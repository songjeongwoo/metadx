package com.ktds.metadx.member.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ktds.metadx.member.dto.MemberDTO;

@Transactional
public interface MemberService {

    void saveMember(MemberDTO member);

}