package com.ktds.metadx.member.mapper;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ktds.metadx.member.dto.MemberDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberMapperTests {
    
    @Autowired(required = false)
    MemberMapper memberMapper;

    // 10개 데이터 넣기
    @Test
    public void testInsert10(){

        IntStream.rangeClosed(1, 10).forEach(i ->{
            MemberDTO member = MemberDTO.builder()
                .email("test" + i + "@ktds.com")
                .pw("testpw" + i)
                .uname("testname" + i)
                // .lockbool(false)
                // .auth(false)
                .did((long)0)
                .jno((long)0)
                .tid((long)0)
                .build();
                
            memberMapper.saveMember(member);
        });
    }

}
