package com.aiden.pms.global.security.jwt;

public enum JwtClaims {
    PJT_ID("pjtId");

    private final String key;
    JwtClaims(String key) { this.key = key; }
    public String key() { return key; }

}
