package com.aiden.pms.global.security.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class LoginUsrAuthDto {
    private String usrId;
    private String authority;

    @QueryProjection
    public LoginUsrAuthDto(String usrId, String authority) {
        this.usrId = usrId;
        this.authority = authority;
    }

}
