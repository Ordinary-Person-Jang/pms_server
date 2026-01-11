package com.aiden.pms.global.security.store;

import com.aiden.pms.global.security.entity.RefreshToken;
import com.aiden.pms.global.security.repository.UsrRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisTokenStore {

    private final UsrRedisRepository redisRepository;

    public void register(RefreshToken refreshToken) {
        redisRepository.save(refreshToken);
    }
    public boolean exists(String token) {
        return redisRepository.existsById(token);
    }

    public void extendTtl(String token, String usrId) {
        redisRepository.save(new RefreshToken(token, usrId));
    }
}
