package com.ktds.metadx.admin.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminLockDTO {
    private Long blno;
    private String email;

    @JsonFormat(pattern="yyyy-MM-dd, hh:mm:ss")
    private LocalDateTime blockdate;

    // getLockAccout용
    private Long islock;
}
