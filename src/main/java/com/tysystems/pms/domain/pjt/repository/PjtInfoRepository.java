package com.tysystems.pms.domain.pjt.repository;

import com.tysystems.pms.domain.pjt.dto.PjtInfoDto;

import java.util.List;

public interface PjtInfoRepository {
    List<PjtInfoDto> selectPjtList();
}
