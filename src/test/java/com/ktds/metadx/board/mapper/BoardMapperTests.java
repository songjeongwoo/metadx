package com.ktds.metadx.board.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ktds.metadx.board.dto.BoardDTO;
import com.ktds.metadx.board.dto.PageRequestDTO;

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
}
