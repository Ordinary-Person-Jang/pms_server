package com.aiden.pms.domain.pjt.repository;

import com.aiden.pms.domain.pjt.dto.PjtInfoDto;

import java.util.List;

public interface PjtInfoRepository {
    List<PjtInfoDto> selectPjtList();
}
