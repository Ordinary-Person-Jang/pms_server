package com.devjang.pms.domain.pjt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pjt {
    @Id
    @Column(name = "PJT_ID")
    private String id;
    private String pjtNm;
    private String strtYmd;
    private String endYmd;
    private String openYmd;
    private String custCmpnyNm;
    private String pmUsrId;
    private String custPmUsrId;
    private String qamUsrId;
    private String entDivCd;
    private String custCmpnyTypCd;
    private String entSummCtnt;
    private String prgrsDdlinDayCd;
    private String pjtAtchFileId;
    private char testMgmtUseYn;

    @OneToMany(mappedBy = "pjt")
    private List<PjtStfOview> stfOviews = new ArrayList<PjtStfOview>();

    public Pjt() {
    }
}
