package com.tysystems.pms.global.security.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.tysystems.pms.global.security.dto.QLoginUsrAuthDto is a Querydsl Projection type for LoginUsrAuthDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QLoginUsrAuthDto extends ConstructorExpression<LoginUsrAuthDto> {

    private static final long serialVersionUID = -175175738L;

    public QLoginUsrAuthDto(com.querydsl.core.types.Expression<String> usrId, com.querydsl.core.types.Expression<String> authority) {
        super(LoginUsrAuthDto.class, new Class<?>[]{String.class, String.class}, usrId, authority);
    }

}

