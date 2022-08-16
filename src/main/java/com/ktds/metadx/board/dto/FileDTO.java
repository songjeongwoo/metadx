package com.ktds.metadx.board.dto;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {

    private Long fno;
    private String fname;
    private String fkey;
    private LocalDateTime fregDate;
    private LocalDateTime fmodDate;
    private String fdatatype;
    private String fuuid;

    // private BoardDTO board;
    private Long bno;

    private MultipartFile[] files;
    
}
