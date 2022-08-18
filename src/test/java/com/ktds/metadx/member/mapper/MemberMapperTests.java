package com.ktds.metadx.member.mapper;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ktds.metadx.member.dto.MemberDTO;
import com.ktds.metadx.member.service.MemberService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberMapperTests {
    
    @Autowired(required = false)
    MemberMapper memberMapper;

    @Autowired
    MemberService memberService;

    // 10개 데이터 넣기
    @Test
    public void testInsert10(){

        IntStream.rangeClosed(1, 10).forEach(i ->{
            MemberDTO member = MemberDTO.builder()
                .email("test" + i + "@ktds.com")
                .mpw("testpw" + i)
                .mname("testname" + i)
                // .lockbool(false)
                // .auth(false)
                .dno((long)0)
                .jno((long)0)
                .tno((long)0)
                .build();
                
            memberMapper.saveMember(member);
        });
    }

    @Test
    public void aa(){
        String email = "123@kt.com";
        memberService.findEmail(email);
    }

}
