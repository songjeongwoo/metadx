package com.ktds.metadx.admin.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
    private Long hno;
    private Long hbool;
    private LocalDateTime hreg_date;
    private Long bno;
    private Long jno;
    private Long dno;
    private Long fno;
}
