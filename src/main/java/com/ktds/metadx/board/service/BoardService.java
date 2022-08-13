package com.ktds.metadx.board.service;

import org.springframework.transaction.annotation.Transactional;

import com.ktds.metadx.board.dto.BoardDTO;
import com.ktds.metadx.board.dto.PageRequestDTO;
import com.ktds.metadx.board.dto.PageResponseDTO;

@Transactional
public interface BoardService {
    public PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO);
    public boolean addPost(BoardDTO boardDTO);
    public BoardDTO detailPost(Long bno);
}
