package com.tysystems.pms.global.utils;

import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.DateTemplate;
import com.querydsl.core.types.dsl.StringPath;

import static com.querydsl.core.types.dsl.Expressions.asString;
import static com.querydsl.core.types.dsl.Expressions.dateTemplate;

public class QuerydslUtil {

    public DateTemplate<String> dateFormat(StringPath stringPath) {
        return dateTemplate(String.class, "DATE_FORMAT({0}, {1})", stringPath, ConstantImpl.create("%Y-%m-%d"));
    }
    public BooleanExpression oneEqOne() {
        return asString("1").eq("1");
    }
}
