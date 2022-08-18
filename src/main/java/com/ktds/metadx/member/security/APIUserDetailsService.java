package com.ktds.metadx.member.security;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ktds.metadx.member.dto.MemberDTO;
import com.ktds.metadx.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class APIUserDetailsService implements UserDetailsService {

    private final MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        MemberDTO result = memberService.findEmail(email);

        log.info("APIUserDetailsService apiUser---------------");
    
        MemberDTO dto = null;

        if(result.isIsadmin() == true){
            dto = new MemberDTO(
                result.getEmail(),
                result.getMpw(),
                result.getMname(),
                result.getDno(),
                result.getJno(),
                result.getTno(),
                true,
                result.isIslock()
                );
        }else{
            dto = new MemberDTO(
                result.getEmail(),
                result.getMpw(),
                result.getMname(),
                result.getDno(),
                result.getJno(),
                result.getTno(),
                false,
                result.isIslock());
        }
        
        log.info("APIUserDetailsService");
        log.info(dto);

        return (UserDetails) dto;

    }
    
}
