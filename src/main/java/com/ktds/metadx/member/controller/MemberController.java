package com.ktds.metadx.member.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktds.metadx.member.dto.MemberDTO;
import com.ktds.metadx.member.service.MailService;
import com.ktds.metadx.member.service.MemberService;
import com.ktds.metadx.member.util.JWTUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private final MailService mailService;

    private final JWTUtil jwtUtil;

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

    @PostMapping("mail")
    public Map<String, String> sendMail(@RequestBody String email, HttpServletRequest request){

        log.info("============== 메일 전송 시작 ==========");

        try {
            email = URLDecoder.decode(email, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Map.of("result", "fail");
        }

        String code = mailService.sendSimpleMessage(email);

        HttpSession session = request.getSession();

        session.setAttribute("mail_chk", code);
        log.info(session.getAttribute("mail_chk"));

        log.info("메일 전송 완료");

        return Map.of("result", "sueccess");
    }

    @PostMapping("mail_chk")
    public String mail_chk(HttpServletRequest request){
        log.info("================인증번호 비교============");
        
        HttpSession session = request.getSession();
        String code = (String)session.getAttribute("mail_chk");

        return code;
    }

    @PostMapping("/login")
    public Map<String, String> loginPOST( @RequestBody MemberDTO memberDTO){
        log.info("====================");
        log.info("로그인 입력 페이지 POST");
        log.info("====================");

        MemberDTO member = memberService.loginMember(memberDTO);

        if(member != null){ // 로그인 성공 시

            Map<String, Object> map = new HashMap<>();
            map.put("mid", memberDTO.getEmail()); 
            map.put("grade", memberDTO.isIsadmin()?"ADMIN":"USER"); 
            String dno = Long.toString(member.getDno());
            String tno = Long.toString(member.getTno());


            log.info(memberDTO.getEmail());

            String accessToken = jwtUtil.generateToken(map, 1);
            String refreshToken = jwtUtil.generateToken(map, 30);

            log.info( memberDTO.getEmail());

            log.info("--------------------------------------------");
            log.info("accessToken: " + accessToken);
            log.info("refreshToken: " +refreshToken);

            if(member.isIsadmin() == true)
            {        
                log.info("========== 관리자 권한 로그인 ========" + member.isIsadmin());
                log.info(member.getEmail() + "님이 로그인 되었습니다");
                log.info("====================");
                
                return Map.of("result", "admin", "accessToken", accessToken, "refreshToken", refreshToken);
            }
            else{
                log.info("=========회원 전용 로그인 ===========" + member.isIsadmin());
                log.info(member.getEmail() + "님이 로그인 되었습니다");
                log.info("====================");
                return Map.of("result", "member", "accessToken", accessToken, "refreshToken", refreshToken, "dno", dno, "tno", tno);
            }
        } else{ // 로그인 실패 시
            log.info("====================");
            log.info("로그인 실패");
            log.info("====================");
            return Map.of("result", "fail");
        }
    }

    @PostMapping("pwreset")
    public Map<String, String> pwReset(@RequestBody MemberDTO memberDTO){
        
        log.info("=================");
        log.info(memberDTO);

        if(memberDTO.getEmail() != null){
            log.info("=======패스워드 초기화========");
            int count = memberService.reset(memberDTO);
            log.info(count);
            return Map.of("result", "success");
        }else{
            log.info("=========패스워드 초기화 실패=======");
            return Map.of("result", "fail");
        }
    }

    @PostMapping("delete")
    public Map<String, String> deleteMember(@RequestBody MemberDTO memberDTO){
        
        log.info("====== delete Controller ==========");
        log.info(memberDTO);
        if(memberDTO.getEmail() != "" && memberDTO.getMpw() != ""){
            memberService.deleteMember(memberDTO);
            log.info("=======회원 탈퇴 완료======");
            return Map.of("result", "success");
        }else{
            log.info("=======회원 탈퇴 실패======");
            return Map.of("result", "fail"); 
        }
    }

    @PostMapping("userlock")
    public boolean userLock(@RequestBody String email){
        try {
            email = URLDecoder.decode(email, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        email = email.substring(0, email.length()-1);
        return memberService.userLock(email);
    }
}
