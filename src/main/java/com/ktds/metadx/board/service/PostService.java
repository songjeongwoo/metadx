package com.ktds.metadx.board.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ktds.metadx.board.dto.PostDTO;

@Transactional
public interface PostService {
    public String fileDataType(PostDTO postDTO);
    
    public boolean insertData(String fname, String fkey, String fuuid, String fileDataType);
}
