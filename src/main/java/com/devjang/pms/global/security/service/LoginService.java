package com.devjang.pms.global.security.service;

import com.devjang.pms.web.form.security.LoginRequestForm;
import com.devjang.pms.global.security.dto.LoginUsrAuthDto;
import com.devjang.pms.domain.usr.repository.UsrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UsrRepository usrRepository;

    public List<LoginUsrAuthDto> setLoginUsrAuth(LoginRequestForm from){
        return usrRepository.selectLoginUsrAuth(from);
    }
}
