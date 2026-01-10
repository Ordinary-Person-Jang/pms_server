package com.devjang.pms.domain.pjt.repository;

import com.devjang.pms.domain.pjt.dto.PjtInfoDto;

import java.util.List;

public interface PjtInfoRepository {
    List<PjtInfoDto> selectPjtList();
}
