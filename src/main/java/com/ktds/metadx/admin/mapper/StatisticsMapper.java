package com.ktds.metadx.admin.mapper;

import java.util.List;

import com.ktds.metadx.admin.dto.AdminDTO;
import com.ktds.metadx.admin.dto.AdminLockDTO;

public interface StatisticsMapper {
    List<AdminDTO> getList(); 

    List<AdminLockDTO> getLockList();

    int getCountDownloads();
}
