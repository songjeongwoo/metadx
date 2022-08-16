package com.ktds.metadx.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ktds.metadx.board.dto.BoardDTO;
import com.ktds.metadx.board.dto.PageRequestDTO;
import com.ktds.metadx.board.dto.PageResponseDTO;
import com.ktds.metadx.board.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {
    
    private final BoardMapper mapper;

    @Override
    public PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO) {
        List<BoardDTO> list = mapper.getList(pageRequestDTO);
		int total = mapper.getListCount(pageRequestDTO);
        return PageResponseDTO.<BoardDTO>withAll().dtoList(list).total(total).pageRequestDTO(pageRequestDTO).build();
    }

    @Override
    public BoardDTO getPost(Long bno) {
        return mapper.getPost(bno);
    }

    @Override
    public boolean delPost(Long bno) {
        return mapper.delPost(bno) > 0;
    }

    @Override
    public Long addPost(BoardDTO boardDTO) {
        log.info("Service===================");
        log.info(boardDTO.getBno());
        mapper.insertPost(boardDTO);
        return boardDTO.getBno();
    }

    @Override
    public boolean modifyPost(BoardDTO boardDTO) {
        return mapper.updatePost(boardDTO) > 0;
    }
}
