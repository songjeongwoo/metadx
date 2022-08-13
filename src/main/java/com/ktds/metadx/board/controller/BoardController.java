package com.ktds.metadx.board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ktds.metadx.board.dto.BoardDTO;
import com.ktds.metadx.board.dto.PageRequestDTO;
import com.ktds.metadx.board.dto.PageResponseDTO;
import com.ktds.metadx.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

// @Controller
@RestController
@Log4j2
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/list")
    public PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO) {
        return service.getList(pageRequestDTO);
    }

    @GetMapping("/addPost")
    public void getAddPostPage() {

    }

    @ResponseBody
    @PostMapping("/addPost")
    public void addPost(BoardDTO boardDTO) {
        log.info("===============================");
        log.info(service.addPost(boardDTO));

        //redirect는 ajax로 리팩토링
    }

    // @GetMapping("/{bno}")
    // public ModelAndView read(@PathVariable("bno") Long bno) {
    //     ModelAndView mv = new ModelAndView();
    //     log.info("==============================bno========================");
    //     log.info(bno);
    //     log.info("==============================detail========================");
    //     mv.addObject("detailPost", service.detailPost(bno));
    //     mv.setViewName("board/detailPost.html");
    //     return mv;
    // }
}
