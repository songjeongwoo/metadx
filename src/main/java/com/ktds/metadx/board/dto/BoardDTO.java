package com.ktds.metadx.board.dto;

import java.time.LocalDate;

import com.ktds.metadx.member.dto.MemberDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Long bno;
    private String title;
    private String content;
    private LocalDate regDate;
    private LocalDate modDate;
    private int isFiles;
    private MemberDTO member;
}
