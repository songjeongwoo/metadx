package com.ktds.metadx.board.mapper;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ktds.metadx.board.dto.BoardDTO;
import com.ktds.metadx.board.dto.PageRequestDTO;
import com.ktds.metadx.member.dto.MemberDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardMapperTests {
    @Autowired
    BoardMapper boardMapper;

    @Test
    public void testList() {

        PageRequestDTO dto = PageRequestDTO.builder().build();
		
		List<BoardDTO> list = boardMapper.getList(dto);
		
		list.forEach(listDTO -> log.info(listDTO));
    }

    @Test
    public void testDel() {

        Long bno = 153L;
		
		boolean result = boardMapper.delPost(bno) > 0;
		
		log.info(result);
    }

    @Test
    public void testAdd() {
        MemberDTO member = MemberDTO.builder()
            .mname("test").mpw("test")
            .email("user1@kt.com").build();

        BoardDTO dto = BoardDTO.builder()
            .title("addTest").content("addTest")
            .regDate(LocalDate.now()).member(member)
            .isFiles(false).build();

		boolean result = boardMapper.insertPost(dto) > 0;
		
		log.info(result);

        Long bno = boardMapper.insertPost(dto);
        log.info("=======================");
        log.info(dto.getBno());
        log.info("=======================");
    }

    @Test
    public void testMod() {
        MemberDTO member = MemberDTO.builder()
            .mname("test").mpw("test")
            .email("user1@kt.com").build();

        BoardDTO dto = BoardDTO.builder()
            .bno(160L).title("modTest").content("modTest")
            .modDate(LocalDate.now()).member(member)
            .isFiles(false).build();

		boolean result = boardMapper.updatePost(dto) > 0;
		
		log.info(result);
    }
}
