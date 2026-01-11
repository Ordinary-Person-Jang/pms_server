package com.aiden.pms.global.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final JwtProperties jwtProperties;

    public String createAccessToken(JwtPayload payload) {
        return JWT.create()
                .withSubject(payload.loginId())
                .withClaim(JwtClaims.PJT_ID.key(), payload.pjtId())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtProperties.getExpirationTime()))
                .sign(Algorithm.HMAC512(jwtProperties.getSecret()));
    }

    public JwtPayload parse(String token){
        DecodedJWT decoded = JWT.require(Algorithm.HMAC512(jwtProperties.getSecret()))
                .build()
                .verify(token);

        String loginId = decoded.getSubject();
        String pjtId = decoded.getClaim(JwtClaims.PJT_ID.key()).asString();
        return new JwtPayload(loginId, pjtId);
    }
}
