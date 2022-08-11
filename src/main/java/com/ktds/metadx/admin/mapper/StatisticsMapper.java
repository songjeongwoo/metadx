package com.ktds.metadx.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.ktds.metadx.admin.dto.AdminDTO;

public interface StatisticsMapper {
    List<AdminDTO> getList(); 
}
