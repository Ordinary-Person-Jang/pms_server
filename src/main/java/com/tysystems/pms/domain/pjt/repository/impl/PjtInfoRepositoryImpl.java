package com.tysystems.pms.domain.pjt.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tysystems.pms.domain.pjt.dto.PjtInfoDto;
import com.tysystems.pms.domain.pjt.dto.QPjtInfoDto;
import com.tysystems.pms.domain.pjt.repository.PjtInfoRepository;
import com.tysystems.pms.global.utils.QuerydslUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static com.tysystems.pms.domain.pjt.entity.QPjt.*;

@Slf4j
@RequiredArgsConstructor
public class PjtInfoRepositoryImpl implements PjtInfoRepository {

    private final JPAQueryFactory queryFactory;
    private final QuerydslUtil querydslUtil;

    @Override
    public List<PjtInfoDto> selectPjtList() {
        List<PjtInfoDto> fetch = queryFactory
                .select(new QPjtInfoDto(
                        pjt.id,
                        pjt.pjtNm,
                        querydslUtil.dateFormat(pjt.strtYmd),
                        querydslUtil.dateFormat(pjt.endYmd),
                        pjt.custCmpnyNm
                )).from(pjt)
                .fetch();
        return fetch;
    }
}
