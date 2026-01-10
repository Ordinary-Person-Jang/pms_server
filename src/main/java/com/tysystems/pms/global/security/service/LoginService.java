package com.tysystems.pms.global.security.service;

import com.tysystems.pms.global.security.dto.LoginUsrAuthDto;
import com.tysystems.pms.domain.usr.repository.UsrRepository;
import com.tysystems.pms.web.form.security.LoginRequestForm;
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
