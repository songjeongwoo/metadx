package com.ktds.metadx.admin.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO 테스트용
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class History {
    private Long hid;
    private Long hbool;
    private LocalDateTime hreg_date;
    private Long bid;
    private Long jno;
    private Long did;
    private Long fid;
}
