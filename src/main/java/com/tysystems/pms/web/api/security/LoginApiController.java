package com.tysystems.pms.web.api.security;

import com.tysystems.pms.global.security.entity.PrincipalDetails;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginApiController {

    @PostMapping("/login")
    private LoginMsg Login(HttpServletRequest req){
        PrincipalDetails principal = (PrincipalDetails) req.getAttribute("principal");
        return new LoginMsg(principal.getUsr().getUsrId(), 200);
    }

    @Data
    class LoginMsg{
        private String id;
        private int code;

        public LoginMsg(String id, int code) {
            this.id = id;
            this.code = code;
        }
    }
}
