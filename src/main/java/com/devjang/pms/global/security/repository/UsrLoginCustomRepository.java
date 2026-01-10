package com.devjang.pms.global.security.repository;

import com.devjang.pms.web.form.security.LoginRequestForm;
import com.devjang.pms.global.security.dto.LoginUsrAuthDto;
import com.devjang.pms.global.security.dto.LoginUsrInfoDto;

import java.util.List;

public interface UsrLoginCustomRepository {
    List<LoginUsrInfoDto> loginUsrSearch(LoginRequestForm form);

    List<LoginUsrAuthDto> selectLoginUsrAuth(LoginRequestForm form);
}
