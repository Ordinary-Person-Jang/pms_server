package com.tysystems.pms.domain.usr.repository;

import com.tysystems.pms.domain.usr.entity.Usr;
import com.tysystems.pms.global.security.repository.UsrLoginCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsrRepository extends JpaRepository<Usr, String>, UsrLoginCustomRepository {

    List<Usr> findUsrByUsrId(String id);
}
