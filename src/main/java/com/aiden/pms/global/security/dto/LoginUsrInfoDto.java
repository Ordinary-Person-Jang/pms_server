package com.aiden.pms.global.security.dto;

import com.aiden.pms.domain.usr.entity.Authority;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.util.List;

@Getter
public class LoginUsrInfoDto {

    private String usrId;

    private String password;

    private String pjtId;

    private String pjtNm;

    private String name;
    private String companyName;

    private Authority authority;

    private String deptNm;

    private String phone;

    private String email;
    private String techGrd;

    private List<LoginUsrAuthDto> Role;

    private String isAdmin;

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setRole(List<LoginUsrAuthDto> role) {
        Role = role;
    }

    @QueryProjection
    public LoginUsrInfoDto(String usrId, String pjtId, Authority authority) {
        this.usrId = usrId;
        this.pjtId = pjtId;
        this.authority = authority;
    }

    @QueryProjection
    public LoginUsrInfoDto(String usrId, String password, String pjtId, Authority authority) {
        this.usrId = usrId;
        this.password = password;
        this.pjtId = pjtId;
        this.authority = authority;
    }
}
