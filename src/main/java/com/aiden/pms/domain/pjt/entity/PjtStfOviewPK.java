package com.aiden.pms.domain.pjt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@RequiredArgsConstructor
public class PjtStfOviewPK implements Serializable {
    @Column(name = "PJT_ID")
    private String pjtId;

    @Column(name = "USR_ID")
    private String usrId;
}
