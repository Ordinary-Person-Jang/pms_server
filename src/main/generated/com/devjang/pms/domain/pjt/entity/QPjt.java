package com.devjang.pms.domain.pjt.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPjt is a Querydsl query type for Pjt
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPjt extends EntityPathBase<Pjt> {

    private static final long serialVersionUID = -986486977L;

    public static final QPjt pjt = new QPjt("pjt");

    public final StringPath custCmpnyNm = createString("custCmpnyNm");

    public final StringPath custCmpnyTypCd = createString("custCmpnyTypCd");

    public final StringPath custPmUsrId = createString("custPmUsrId");

    public final StringPath endYmd = createString("endYmd");

    public final StringPath entDivCd = createString("entDivCd");

    public final StringPath entSummCtnt = createString("entSummCtnt");

    public final StringPath id = createString("id");

    public final StringPath openYmd = createString("openYmd");

    public final StringPath pjtAtchFileId = createString("pjtAtchFileId");

    public final StringPath pjtNm = createString("pjtNm");

    public final StringPath pmUsrId = createString("pmUsrId");

    public final StringPath prgrsDdlinDayCd = createString("prgrsDdlinDayCd");

    public final StringPath qamUsrId = createString("qamUsrId");

    public final ListPath<PjtStfOview, QPjtStfOview> stfOviews = this.<PjtStfOview, QPjtStfOview>createList("stfOviews", PjtStfOview.class, QPjtStfOview.class, PathInits.DIRECT2);

    public final StringPath strtYmd = createString("strtYmd");

    public final ComparablePath<Character> testMgmtUseYn = createComparable("testMgmtUseYn", Character.class);

    public QPjt(String variable) {
        super(Pjt.class, forVariable(variable));
    }

    public QPjt(Path<? extends Pjt> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPjt(PathMetadata metadata) {
        super(Pjt.class, metadata);
    }

}

