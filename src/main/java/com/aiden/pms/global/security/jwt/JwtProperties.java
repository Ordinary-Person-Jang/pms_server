package com.aiden.pms.global.security.jwt;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class JwtProperties {

    @Value("${jwt.secret}")
    private String Secret;

    @Value("${jwt.expiration-time}")
    private int expirationTime;

}
