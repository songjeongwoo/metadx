package com.ktds.metadx.member.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.metadx.member.dto.MemberDTO;
import com.ktds.metadx.member.service.MailService;
import com.ktds.metadx.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // private final MailService mailService;

    @GetMapping("/add")
    public ModelAndView membersaveGet(){
        log.info("====================");
        log.info("회원가입 시작");
        log.info("====================");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("member/addMember.html");
        return mav;
    }

    @PostMapping("/add")
    public Map<String, String> membersavePost( @RequestBody MemberDTO memberDTO){
        log.info("===================ddd================");
        log.info(memberDTO);
        memberService.addMember(memberDTO);
        log.info("====================");
        log.info("회원가입 완료");
        log.info("====================");
        
        return Map.of("result", "success");
    }

    @GetMapping("/login")
    public ModelAndView login(){
        log.info("====================");
        log.info("로그인 입력 페이지 GET");
        log.info("====================");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("member/loginForm.html");
        return mav;
    }

    @PostMapping("/login")
    public Map<String, String> loginPOST(@RequestBody MemberDTO memberDTO, HttpSession session){
        log.info("====================");
        log.info("로그인 입력 페이지 POST");
        log.info("====================");

        MemberDTO member = memberService.loginMember(memberDTO);
        
        if(member != null){ // 로그인 성공 시
            log.info("====================");
            log.info(member.getEmail() + "님이 로그인 되었습니다");
            log.info("====================");
            return Map.of("result", "success");
        } else{ // 로그인 실패 시
            log.info("====================");
            log.info("로그인 실패");
            log.info("====================");
            return Map.of("result", "fail");
        }
    }

    @GetMapping("/logout")
    public Map<String, String> logout(HttpSession session){
        log.info("===========================");
        log.info("로그아웃 되었습니다");
        log.info("===========================");
        session.invalidate();
        return Map.of("result", "success");
    }

}
