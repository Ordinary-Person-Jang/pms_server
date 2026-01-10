package com.aiden.pms.domain.usr.entity;

public enum Role {
    /** 프로젝트 관리자 동등 권한 */
    SU,

    /** 프로젝트 관리자(PM) */
    PM,

    /** 품질 관리자*/
    QO,

    /** 품질 보증 관리자 */
    QAM,

    /** 파트리더 */
    PL,

    /** 결함관리자 */
    DM,

    /** 문의사항 담당자 */
    IM

}
