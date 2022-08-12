package com.ktds.metadx.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.metadx.member.dto.MemberDTO;
import com.ktds.metadx.member.service.MailService;
import com.ktds.metadx.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Controller
@Log4j2
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // private final MailService mailService;

    // @GetMapping("/add")
    // public String membersaveGet(){
    //     log.info("====================");
    //     log.info("회원가입 시작");
    //     log.info("====================");
    //     return "member/addMember.html";
    // }

    @PostMapping("/add")
    public String membersavePost(MemberDTO memberDTO){
        memberService.saveMember(memberDTO);
        log.info("====================");
        log.info("회원가입 완료");
        log.info("====================");
        return "member/loginForm.html";
    }

    // @GetMapping("/login")
    // public String login(){
    //     log.info("====================");
    //     log.info("로그인 입력 페이지 GET");
    //     log.info("====================");
    //     return "member/loginForm.html";
    // }

    @PostMapping("/login")
    public ModelAndView loginPOST(@ModelAttribute MemberDTO memberDTO, HttpSession session){
        log.info("====================");
        log.info("로그인 입력 페이지 POST");
        log.info("====================");

        MemberDTO member = memberService.loginMember(memberDTO);
        ModelAndView mav = new ModelAndView();
        
        if(member != null){ // 로그인 성공 시
            log.info("====================");
            log.info(member.getEmail() + "님이 로그인 되었습니다");
            log.info("====================");
            mav.setViewName("member/member_access.html");
            mav.addObject("member", member);
        } else{ // 로그인 실패 시
            log.info("====================");
            log.info("로그인 실패");
            log.info("====================");
            mav.setViewName("member/loginForm.html");
            mav.addObject("message", "error");
        }
        return mav;
    }

    // @GetMapping("/logout")
    // public String logout(HttpSession session){
    //     log.info("===========================");
    //     log.info("로그아웃 되었습니다");
    //     log.info("===========================");
    //     session.invalidate();
    //     return "redirect:/member/login";
    // }

}
