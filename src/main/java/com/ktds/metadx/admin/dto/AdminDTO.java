package com.ktds.metadx.admin.dto;

import java.sql.Timestamp;
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
    private Long hid;
    private Long hbool;
    private LocalDateTime hreg_date;
    private Long bid;
    private Long jno;
    private Long did;
    private Long fid;
}
