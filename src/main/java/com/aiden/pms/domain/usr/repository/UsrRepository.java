package com.aiden.pms.domain.usr.repository;

import com.aiden.pms.global.security.repository.UsrLoginCustomRepository;
import com.aiden.pms.domain.usr.entity.Usr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsrRepository extends JpaRepository<Usr, String>, UsrLoginCustomRepository {

    List<Usr> findUsrByUsrId(String id);
}
