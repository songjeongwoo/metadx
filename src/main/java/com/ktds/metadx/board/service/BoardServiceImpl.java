package com.ktds.metadx.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ktds.metadx.board.dto.BoardDTO;
import com.ktds.metadx.board.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    
    private final BoardMapper mapper;

    @Override
    public List<BoardDTO> getList() {
        return mapper.getList();
    }
}
