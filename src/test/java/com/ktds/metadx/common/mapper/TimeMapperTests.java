package com.ktds.metadx.common.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TimeMapperTests {
    @Autowired(required = false)
    TimeMapper timemapper;
    
    @Test
    public void test() {
        log.info(timemapper.getTime());
    }
}
