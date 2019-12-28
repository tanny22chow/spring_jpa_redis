package com.springPrac.springredisdemo.Model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QApplicationFee is a Querydsl query type for ApplicationFee
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QApplicationFee extends EntityPathBase<ApplicationFee> {

    private static final long serialVersionUID = -736314072L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QApplicationFee applicationFee = new QApplicationFee("applicationFee");

    public final QApplicationDetail applicationDetail;

    public final NumberPath<Long> fee_process_cd = createNumber("fee_process_cd", Long.class);

    public final NumberPath<Long> transaction_id = createNumber("transaction_id", Long.class);

    public QApplicationFee(String variable) {
        this(ApplicationFee.class, forVariable(variable), INITS);
    }

    public QApplicationFee(Path<? extends ApplicationFee> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QApplicationFee(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QApplicationFee(PathMetadata metadata, PathInits inits) {
        this(ApplicationFee.class, metadata, inits);
    }

    public QApplicationFee(Class<? extends ApplicationFee> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.applicationDetail = inits.isInitialized("applicationDetail") ? new QApplicationDetail(forProperty("applicationDetail"), inits.get("applicationDetail")) : null;
    }

}

