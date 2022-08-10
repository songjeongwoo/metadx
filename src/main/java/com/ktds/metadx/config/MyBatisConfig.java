package com.ktds.metadx.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.ktds.metadx.**.mapper"})
public class MyBatisConfig {
    
}
