package com.tysystems.pms.web.form.security;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginRequestForm {
    private String id;
    private String pjtId;
    private String password;

    public LoginRequestForm(String id, String pjtId) {
        this.id = id;
        this.pjtId = pjtId;
    }
}
