package com.ktds.metadx.board.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ktds.metadx.board.dto.BoardDTO;

@Transactional
public interface BoardService {
    public List<BoardDTO> getList();
}
