package com.ktds.metadx.member.dto;

import org.apache.ibatis.session.SqlSession;

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
    private String pw;
    private String uname;
    // private boolean lockbool;
    // private boolean auth;
    private Long did;
    private Long jno;
    private Long tid;

}
