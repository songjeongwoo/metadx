package com.ktds.metadx.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ktds.metadx.admin.dto.AdminDTO;
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
    
}
