package com.ktds.metadx.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ktds.metadx.board.dto.PostDTO;
import com.ktds.metadx.board.mapper.PostMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;



@Service
@Log4j2
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    
    private final PostMapper mapper;
    
    @Override
    public boolean insertData(String fname, String fkey, String fuuid, String fileDataType) {
        return mapper.insertFile(fname, fkey, fuuid, fileDataType) > 0;
    }

}
