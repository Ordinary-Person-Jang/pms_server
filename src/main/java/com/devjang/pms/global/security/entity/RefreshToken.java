package com.devjang.pms.global.security.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@NoArgsConstructor
@Getter
@ToString
@RedisHash(value = "refreshToken", timeToLive = 1800)
public class RefreshToken {
    @Id
    private String token;
    private String usrId;

    public RefreshToken(String token, String usrId) {
        this.token = token;
        this.usrId = usrId;
    }
}
