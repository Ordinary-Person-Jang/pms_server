package com.devjang.pms.global.security.repository;

import com.devjang.pms.global.security.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface UsrRedisRepository extends CrudRepository<RefreshToken, String> {
}
