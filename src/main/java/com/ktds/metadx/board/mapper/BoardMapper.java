package com.ktds.metadx.board.mapper;

import java.util.List;

import com.ktds.metadx.board.dto.BoardDTO;

public interface BoardMapper {
    List<BoardDTO> getList();
    int insertPost(BoardDTO boardDTO);
    BoardDTO detailPost(Long bno);
}
