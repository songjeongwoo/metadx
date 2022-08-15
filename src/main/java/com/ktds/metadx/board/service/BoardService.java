package com.ktds.metadx.board.service;

import org.springframework.transaction.annotation.Transactional;

import com.ktds.metadx.board.dto.BoardDTO;
import com.ktds.metadx.board.dto.PageRequestDTO;
import com.ktds.metadx.board.dto.PageResponseDTO;

@Transactional
public interface BoardService {
    public PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO);
    
    public BoardDTO getPost(Long bno);

    public boolean delPost(Long bno);
    public boolean addPost(BoardDTO boardDTO);
}
