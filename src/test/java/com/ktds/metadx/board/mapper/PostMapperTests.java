package com.ktds.metadx.board.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class PostMapperTests {
    @Autowired
    FileMapper postMapper;

    // @Test
    // public void testList() {

    //     log.info(postMapper.insertFile(postDTO));
    // }
}
