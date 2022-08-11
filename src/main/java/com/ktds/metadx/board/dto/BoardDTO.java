package com.ktds.metadx.board.dto;

import java.time.LocalDateTime;

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
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private boolean isFiles;
    // private Member member;
}
