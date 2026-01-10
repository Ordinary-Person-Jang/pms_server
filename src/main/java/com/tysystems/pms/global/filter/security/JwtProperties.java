package com.tysystems.pms.global.filter.security;

public interface JwtProperties {
    String SECRET = "PMS_DEV";
    int EXPIRATION_TIME = 60000 * 30;
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
