package com.aiden.pms.domain.pjt.entity;

import com.aiden.pms.domain.common.entity.BaseEntity;
import com.aiden.pms.domain.usr.entity.Usr;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class PjtStfOview extends BaseEntity {

    @Id
    @EmbeddedId
    private PjtStfOviewPK pjtStfOviewPK;
    private String putPlnStrtYmd;
    private String putPlnEndYmd;
    private String putPerfStrtYmd;
    private String putPerfEndYmd;
    private String putStaCd;
    private String putEndReasnCtnt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USR_ID", referencedColumnName = "USR_ID")
    @MapsId("usrId")
    private Usr usr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PJT_ID", referencedColumnName = "PJT_ID")
    @MapsId("pjtId")
    private Pjt pjt;
}
