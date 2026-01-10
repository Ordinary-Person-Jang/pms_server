package com.aiden.pms.domain.pjt.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPjtStfOviewPK is a Querydsl query type for PjtStfOviewPK
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QPjtStfOviewPK extends BeanPath<PjtStfOviewPK> {

    private static final long serialVersionUID = 1580932137L;

    public static final QPjtStfOviewPK pjtStfOviewPK = new QPjtStfOviewPK("pjtStfOviewPK");

    public final StringPath pjtId = createString("pjtId");

    public final StringPath usrId = createString("usrId");

    public QPjtStfOviewPK(String variable) {
        super(PjtStfOviewPK.class, forVariable(variable));
    }

    public QPjtStfOviewPK(Path<? extends PjtStfOviewPK> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPjtStfOviewPK(PathMetadata metadata) {
        super(PjtStfOviewPK.class, metadata);
    }

}

