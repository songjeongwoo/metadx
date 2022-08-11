package com.ktds.metadx.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ktds.metadx.member.dto.MemberDTO;
import com.ktds.metadx.member.service.MailService;
import com.ktds.metadx.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Controller
@Log4j2
@RequestMapping("/member/")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private final MailService mailService;

    // @GetMapping("add")
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String membersaveGet(){
        log.info("====================");
        log.info("회원가입 시작");
        log.info("====================");
        return "addMember.html";
    }

    // @PostMapping("add")
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String membersavePost(MemberDTO memberDTO){
        memberService.saveMember(memberDTO);
        log.info("====================");
        log.info("회원가입 완료");
        log.info("====================");
        return "login2.html";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(){
        log.info("====================");
        log.info("로그인 입력 페이지 GET");
        log.info("====================");
        return "loginForm.html";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String loginPOST(MemberDTO memberDTO, HttpSession session, RedirectAttributes rttr){
        log.info("====================");
        log.info("로그인 입력 페이지 POST");
        log.info("====================");

        MemberDTO memberDTO2 = memberService.loginMember(memberDTO);
        
        if(memberDTO2 != null){
            session.setAttribute("email", memberDTO2.getEmail());

            rttr.addFlashAttribute("mvo", memberDTO2);

            return "redirect:/member/main";
        }else{
            return "redirect:/member/login";
        }

    }

    // @RequestMapping(value="/login", method = RequestMethod.POST)
    // public int login(MemberDTO memberDTO, HttpSession session){
    //     return memberDTO.login(memberDTO, session);
    // }
}
