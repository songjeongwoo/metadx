package com.ktds.metadx.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ktds.metadx.board.dto.FileDTO;
import com.ktds.metadx.board.mapper.FileMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;



@Service
@Log4j2
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    
    private final FileMapper mapper;
    
    @Override
    public boolean insertData(String fname, String fkey, String fuuid, String fileDataType, Long bno) {
        return mapper.insertFile(fname, fkey, fuuid, fileDataType, bno) > 0;
    }

    @Override
    public List<FileDTO> getFileList(Long bno){
        return mapper.getFileList(bno);
    }

}
