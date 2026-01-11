package com.aiden.pms.global.security.jwt;

public record VerifiedToken(String rawToken, JwtPayload payload) {
}
