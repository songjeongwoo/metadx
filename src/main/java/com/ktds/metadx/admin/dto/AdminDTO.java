package com.ktds.metadx.admin.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
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

    private String team;
    private String department;
}
