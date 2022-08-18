package com.ktds.metadx.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ktds.metadx.admin.dto.AdminCountDTO;
import com.ktds.metadx.admin.dto.AdminDTO;
import com.ktds.metadx.admin.dto.AdminLockDTO;
import com.ktds.metadx.admin.mapper.StatisticsMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final StatisticsMapper mapper;

    @Override
    public List<AdminDTO> getList() {
        return mapper.getList();
    }

    @Override
    public List<AdminLockDTO> getLockList() {
        return mapper.getLockList();
    }

    @Override
    public List<AdminCountDTO> getCountLocks() {
        return mapper.getCountLocks();
    }

    @Override
    public List<AdminLockDTO> getLockAccount() {
        return mapper.getLockAccount();
    }

    @Override
    public boolean changeLockAccount(String email) {
        return mapper.changeLockAccount(email) > 0;
    }
   

    @Override
    public List<AdminCountDTO> getCountDownloads() {
        return mapper.getCountDownloads();
    }
    
}
