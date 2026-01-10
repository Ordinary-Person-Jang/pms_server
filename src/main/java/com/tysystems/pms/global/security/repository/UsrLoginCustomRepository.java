package com.tysystems.pms.global.security.repository;

import com.tysystems.pms.global.security.dto.LoginUsrAuthDto;
import com.tysystems.pms.global.security.dto.LoginUsrInfoDto;
import com.tysystems.pms.web.form.security.LoginRequestForm;

import java.util.List;

public interface UsrLoginCustomRepository {
    List<LoginUsrInfoDto> loginUsrSearch(LoginRequestForm form);

    List<LoginUsrAuthDto> selectLoginUsrAuth(LoginRequestForm form);
}
