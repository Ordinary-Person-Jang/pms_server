package com.aiden.pms.global.security.repository;

import com.aiden.pms.global.security.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface UsrRedisRepository extends CrudRepository<RefreshToken, String> {
}
