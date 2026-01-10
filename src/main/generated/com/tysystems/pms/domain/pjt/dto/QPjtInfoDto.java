package com.tysystems.pms.domain.pjt.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.tysystems.pms.domain.pjt.dto.QPjtInfoDto is a Querydsl Projection type for PjtInfoDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QPjtInfoDto extends ConstructorExpression<PjtInfoDto> {

    private static final long serialVersionUID = -444872208L;

    public QPjtInfoDto(com.querydsl.core.types.Expression<String> pjtId, com.querydsl.core.types.Expression<String> pjtNm) {
        super(PjtInfoDto.class, new Class<?>[]{String.class, String.class}, pjtId, pjtNm);
    }

    public QPjtInfoDto(com.querydsl.core.types.Expression<String> pjtId, com.querydsl.core.types.Expression<String> pjtNm, com.querydsl.core.types.Expression<String> strtYmd, com.querydsl.core.types.Expression<String> endYmd, com.querydsl.core.types.Expression<String> custCmpnyNm) {
        super(PjtInfoDto.class, new Class<?>[]{String.class, String.class, String.class, String.class, String.class}, pjtId, pjtNm, strtYmd, endYmd, custCmpnyNm);
    }

}

