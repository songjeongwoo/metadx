package com.ktds.metadx.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.ktds.metadx.admin.domain.History;

public interface StatisticsMapper {
    // @Insert("insert into test (hbool, bid) values (#{hbool}, #{bid})")
    // void insert(History history);

    List<History> getList(); 
}
