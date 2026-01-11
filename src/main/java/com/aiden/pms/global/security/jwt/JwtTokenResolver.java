package com.aiden.pms.global.security.jwt;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Component
public class JwtTokenResolver {

    public Optional<String> resolve(HttpServletRequest request){
        String header = request.getHeader(JwtConstants.HEADER_STRING);
        if(!StringUtils.hasText(header)){
            return  Optional.empty();
        }

        String prefix = JwtConstants.TOKEN_PREFIX;
        if(!header.startsWith(prefix)) return Optional.empty();

        String token = header.substring(prefix.length()).trim();
        return StringUtils.hasText(token) ? Optional.of(token) : Optional.empty();
    }
}
