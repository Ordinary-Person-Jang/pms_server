package com.tysystems.pms.web.handler.exHandler;

import lombok.Getter;

@Getter
public enum ErrorCode {
    No_Exist_Token(403, "No Exist Token"),
    Expried_Token(403, "이미 만료된 토큰입니다."),
    Access_Denied(403, "접근권한이 없습니다."),
    BadCredentials(500, "자격증명에 실패하였습니다.");

    private int code;
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
