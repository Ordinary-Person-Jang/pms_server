package com.devjang.pms.domain.pjt.repository.impl;

import com.devjang.pms.domain.pjt.dto.QPjtInfoDto;
import com.devjang.pms.domain.pjt.entity.QPjt;
import com.devjang.pms.global.utils.QuerydslUtil;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.devjang.pms.domain.pjt.dto.PjtInfoDto;
import com.devjang.pms.domain.pjt.repository.PjtInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class PjtInfoRepositoryImpl implements PjtInfoRepository {

    private final JPAQueryFactory queryFactory;
    private final QuerydslUtil querydslUtil;

    @Override
    public List<PjtInfoDto> selectPjtList() {
        List<PjtInfoDto> fetch = queryFactory
                .select(new QPjtInfoDto(
                        QPjt.pjt.id,
                        QPjt.pjt.pjtNm,
                        querydslUtil.dateFormat(QPjt.pjt.strtYmd),
                        querydslUtil.dateFormat(QPjt.pjt.endYmd),
                        QPjt.pjt.custCmpnyNm
                )).from(QPjt.pjt)
                .fetch();
        return fetch;
    }
}
