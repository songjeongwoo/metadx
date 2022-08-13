package com.ktds.metadx.admin.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktds.metadx.member.dto.MemberDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
    private Long hno;
    private Long hbool;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime hreg_date;
    
    private Long bno;
    private String email;

    private String 팀;
    private String 본부;
}
