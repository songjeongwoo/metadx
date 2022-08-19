package com.ktds.metadx.admin.mapper;

import java.util.List;

import com.ktds.metadx.admin.dto.AdminCountDTO;
import com.ktds.metadx.admin.dto.AdminDTO;
import com.ktds.metadx.admin.dto.AdminLockDTO;
import com.ktds.metadx.member.dto.MemberDTO;

public interface StatisticsMapper {
    List<AdminDTO> getList();

    List<AdminLockDTO> getLockList();
    List<AdminCountDTO> getCountLocks();
    List<AdminLockDTO> getLockAccount();
    List<AdminDTO> getDelList();
    int changeLockAccount(String email);
    int delAccount(String email);

    List<AdminCountDTO> getCountDownloads();
}
