package com.ktds.metadx.admin.service;

import java.util.List;

import com.ktds.metadx.admin.dto.AdminCountDTO;
import com.ktds.metadx.admin.dto.AdminDTO;
import com.ktds.metadx.admin.dto.AdminLockDTO;
import com.ktds.metadx.member.dto.MemberDTO;

public interface AdminService {
    public List<AdminDTO> getList();

    public List<AdminLockDTO> getLockList();
    public List<AdminCountDTO> getCountLocks();
    public List<AdminLockDTO> getLockAccount();
    public List<AdminDTO> getDelList();
    public boolean changeLockAccount(String email);
    public boolean delAccount(String email);

    public List<AdminCountDTO> getCountDownloads();
}
