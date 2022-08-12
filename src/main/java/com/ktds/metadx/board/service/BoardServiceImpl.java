package com.ktds.metadx.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ktds.metadx.board.dto.BoardDTO;
import com.ktds.metadx.board.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {
    
    private final BoardMapper mapper;

    @Override
    public List<BoardDTO> getList() {
        return mapper.getList();
    }

    @Override
    public boolean addPost(BoardDTO boardDTO) {
        return mapper.insertPost(boardDTO) > 0;
    }

    @Override
    public BoardDTO detailPost(Long bno) {
        return mapper.detailPost(bno);
    }
}
