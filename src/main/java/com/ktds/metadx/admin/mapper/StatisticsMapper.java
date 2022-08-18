package com.ktds.metadx.admin.mapper;

import java.util.List;

import com.ktds.metadx.admin.dto.AdminCountDTO;
import com.ktds.metadx.admin.dto.AdminDTO;
import com.ktds.metadx.admin.dto.AdminLockDTO;

public interface StatisticsMapper {
    List<AdminDTO> getList();

    List<AdminLockDTO> getLockList();
    List<AdminCountDTO> getCountLocks();
    List<AdminLockDTO> getLockAccount();
    int changeLockAccount(String email);

    List<AdminCountDTO> getCountDownloads();
}
