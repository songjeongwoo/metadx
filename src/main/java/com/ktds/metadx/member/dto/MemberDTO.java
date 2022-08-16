package com.ktds.metadx.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    private String email;
    private String mpw;
    private String mname;
    // private boolean lockbool;
    // private boolean auth;
    private Long dno;
    private Long jno;
    private Long tno;

    // 관리자 회원 여부(관리자 일시 1)
    private boolean isadmit;

    // 회원 잠금 여부
    private boolean islock;

}
