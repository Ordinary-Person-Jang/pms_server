package com.devjang.pms.global.security.repository.impl;

import com.devjang.pms.web.form.security.LoginRequestForm;
import com.querydsl.jpa.impl.JPAQueryFactory;
//import com.tysystems.pms.domain.usr.entity.QFAuthUsr;
import com.devjang.pms.global.security.dto.LoginUsrAuthDto;
import com.devjang.pms.global.security.dto.LoginUsrInfoDto;
import com.devjang.pms.global.security.dto.QLoginUsrInfoDto;
import com.devjang.pms.global.security.repository.UsrLoginCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static com.devjang.pms.domain.pjt.entity.QPjt.*;
import static com.devjang.pms.domain.pjt.entity.QPjtStfOview.*;
//import static com.tysystems.pms.domain.usr.entity.QFAuthUsr.*;
import static com.devjang.pms.domain.usr.entity.QUsr.*;


@RequiredArgsConstructor
public class UsrLoginCustomRepositoryImpl implements UsrLoginCustomRepository {
    private final JPAQueryFactory queryFactory;

    private final JdbcTemplate template;
    @Override
    public List<LoginUsrInfoDto> loginUsrSearch(LoginRequestForm form) {
        List<LoginUsrInfoDto> fetch = queryFactory.select(new QLoginUsrInfoDto(
                        usr.usrId,
                        usr.usrPwd,
                        pjt.id,
                        usr.usrTypCd
                ))
                .from(usr)
                .join(pjtStfOview).on(usr.usrId.eq(pjtStfOview.pjtStfOviewPK.usrId))
                .join(pjtStfOview).on(pjt.id.eq(pjtStfOview.pjtStfOviewPK.pjtId))
                .where(
                        usr.usrId.eq(form.getId())
                                .and(pjt.id.eq(form.getPjtId())))
                .fetch();

        return fetch;
    }

    @Override
    public List<LoginUsrAuthDto> selectLoginUsrAuth(LoginRequestForm form) {
//        List<LoginUsrAuthDto> result = queryFactory.select(
//                        new QLoginUsrAuthDto(
//                                fAuthUsr.fAuthUsrPK.usrId,
//                                fAuthUsr.fAuthUsrPK.authId
//                        )
//                )
//                .from(fAuthUsr)
//                .where(fAuthUsr.fAuthUsrPK.usrId.eq(form.getId())
//                        .and(fAuthUsr.fAuthUsrPK.pjtId.eq(form.getPjtId())))
//                .fetch();
//
//        result.add(new LoginUsrAuthDto(form.getId(), "ROLE_NONE"));

        String query = "SELECT USR_ID, AUTH_ID AS AUTHORITY " +
                "FROM (SELECT * FROM F_AUTH_USR) M " +
                "WHERE PJT_ID = ? AND USR_ID = ? " +
                "UNION " +
                "SELECT '', 'ROLE_NONE' " +
                "FROM DUAL";
        List<LoginUsrAuthDto> result = template.query(query, new Object[]{form.getPjtId(), form.getId()},
                (rs, rowNum) ->
                        new LoginUsrAuthDto(rs.getString("USR_ID"), rs.getString("AUTHORITY")));
        return result;
    }
}
