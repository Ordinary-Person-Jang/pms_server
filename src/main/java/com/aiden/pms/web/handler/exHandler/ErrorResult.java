package com.aiden.pms.web.handler.exHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResult {
    private String code;
    private String message;
    private String type;

    public ErrorResult() {}

    public ErrorResult(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
