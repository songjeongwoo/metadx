package com.ktds.metadx.board.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ktds.metadx.board.dto.FileDTO;

@Transactional
public interface FileService {
    public boolean insertData(String fname, String fkey, String fuuid, String fileDataType, Long bno);
    public List<FileDTO> getFileList(Long bno);
    public String getFileFkey(String fuuid);
}
