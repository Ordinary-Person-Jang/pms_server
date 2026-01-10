package com.aiden.pms.domain.pjt.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PjtInfoDto {
    private String pjtId;
    private String pjtNm;
    private String strtYmd;
    private String endYmd;
    private String openYmd;
    private String custCmpnyNm;
    private String pmUsrId;
    private String pmUsrNm;
    private String custPmUsrId;
    private String custPmUsrNm;
    private String qamUsrId;
    private String qamUsrNm;
    private String entDivCd;
    private String custCmpnyTypCd;
    private String entSummCtnt;
    private String prgrsDdlinDayCd;
    private String pjtAtchFileId;

    @QueryProjection
    public PjtInfoDto(String pjtId, String pjtNm) {
        this.pjtId = pjtId;
        this.pjtNm = pjtNm;
    }

    @QueryProjection
    public PjtInfoDto(String pjtId, String pjtNm, String strtYmd, String endYmd, String custCmpnyNm) {
        this.pjtId = pjtId;
        this.pjtNm = pjtNm;
        this.strtYmd = strtYmd;
        this.endYmd = endYmd;
        this.custCmpnyNm = custCmpnyNm;
    }
}
