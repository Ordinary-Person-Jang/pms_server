package com.tysystems.pms.global.security.repository;

import com.tysystems.pms.global.security.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface UsrRedisRepository extends CrudRepository<RefreshToken, String> {
}
