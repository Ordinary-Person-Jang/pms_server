package com.tysystems.pms.domain.pjt.repository;

import com.tysystems.pms.domain.pjt.entity.Pjt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PjtRepository extends JpaRepository<Pjt, String>, PjtInfoRepository {
}
