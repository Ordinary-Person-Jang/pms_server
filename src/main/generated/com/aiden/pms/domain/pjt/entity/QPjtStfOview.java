package com.aiden.pms.domain.pjt.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPjtStfOview is a Querydsl query type for PjtStfOview
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPjtStfOview extends EntityPathBase<PjtStfOview> {

    private static final long serialVersionUID = 748012974L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPjtStfOview pjtStfOview = new QPjtStfOview("pjtStfOview");

    public final com.aiden.pms.domain.common.entity.QBaseEntity _super = new com.aiden.pms.domain.common.entity.QBaseEntity(this);

    //inherited
    public final StringPath mdfyUsrId = _super.mdfyUsrId;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> mdfyYmd = _super.mdfyYmd;

    public final QPjt pjt;

    public final QPjtStfOviewPK pjtStfOviewPK;

    public final StringPath putEndReasnCtnt = createString("putEndReasnCtnt");

    public final StringPath putPerfEndYmd = createString("putPerfEndYmd");

    public final StringPath putPerfStrtYmd = createString("putPerfStrtYmd");

    public final StringPath putPlnEndYmd = createString("putPlnEndYmd");

    public final StringPath putPlnStrtYmd = createString("putPlnStrtYmd");

    public final StringPath putStaCd = createString("putStaCd");

    //inherited
    public final StringPath regUsrId = _super.regUsrId;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regYmd = _super.regYmd;

    public final com.aiden.pms.domain.usr.entity.QUsr usr;

    public QPjtStfOview(String variable) {
        this(PjtStfOview.class, forVariable(variable), INITS);
    }

    public QPjtStfOview(Path<? extends PjtStfOview> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPjtStfOview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPjtStfOview(PathMetadata metadata, PathInits inits) {
        this(PjtStfOview.class, metadata, inits);
    }

    public QPjtStfOview(Class<? extends PjtStfOview> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pjt = inits.isInitialized("pjt") ? new QPjt(forProperty("pjt")) : null;
        this.pjtStfOviewPK = inits.isInitialized("pjtStfOviewPK") ? new QPjtStfOviewPK(forProperty("pjtStfOviewPK")) : null;
        this.usr = inits.isInitialized("usr") ? new com.aiden.pms.domain.usr.entity.QUsr(forProperty("usr")) : null;
    }

}

