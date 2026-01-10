package com.aiden.pms.global.security.repository;

import com.aiden.pms.web.form.security.LoginRequestForm;
import com.aiden.pms.global.security.dto.LoginUsrAuthDto;
import com.aiden.pms.global.security.dto.LoginUsrInfoDto;

import java.util.List;

public interface UsrLoginCustomRepository {
    List<LoginUsrInfoDto> loginUsrSearch(LoginRequestForm form);

    List<LoginUsrAuthDto> selectLoginUsrAuth(LoginRequestForm form);
}
