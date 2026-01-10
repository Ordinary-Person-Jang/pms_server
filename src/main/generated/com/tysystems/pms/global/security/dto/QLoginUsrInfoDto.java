package com.tysystems.pms.global.security.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.tysystems.pms.global.security.dto.QLoginUsrInfoDto is a Querydsl Projection type for LoginUsrInfoDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QLoginUsrInfoDto extends ConstructorExpression<LoginUsrInfoDto> {

    private static final long serialVersionUID = -1878205696L;

    public QLoginUsrInfoDto(com.querydsl.core.types.Expression<String> usrId, com.querydsl.core.types.Expression<String> pjtId, com.querydsl.core.types.Expression<com.tysystems.pms.domain.usr.entity.Authority> authority) {
        super(LoginUsrInfoDto.class, new Class<?>[]{String.class, String.class, com.tysystems.pms.domain.usr.entity.Authority.class}, usrId, pjtId, authority);
    }

    public QLoginUsrInfoDto(com.querydsl.core.types.Expression<String> usrId, com.querydsl.core.types.Expression<String> password, com.querydsl.core.types.Expression<String> pjtId, com.querydsl.core.types.Expression<com.tysystems.pms.domain.usr.entity.Authority> authority) {
        super(LoginUsrInfoDto.class, new Class<?>[]{String.class, String.class, String.class, com.tysystems.pms.domain.usr.entity.Authority.class}, usrId, password, pjtId, authority);
    }

}

