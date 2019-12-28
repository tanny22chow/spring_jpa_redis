package com.springPrac.springredisdemo.Model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QApplicant is a Querydsl query type for Applicant
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QApplicant extends EntityPathBase<Applicant> {

    private static final long serialVersionUID = 892717744L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QApplicant applicant = new QApplicant("applicant");

    public final QLocation address;

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Long> applicant_id = createNumber("applicant_id", Long.class);

    public final QApplicationDetail applicationDetail;

    public final StringPath identification_num = createString("identification_num");

    public final StringPath name = createString("name");

    public QApplicant(String variable) {
        this(Applicant.class, forVariable(variable), INITS);
    }

    public QApplicant(Path<? extends Applicant> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QApplicant(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QApplicant(PathMetadata metadata, PathInits inits) {
        this(Applicant.class, metadata, inits);
    }

    public QApplicant(Class<? extends Applicant> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QLocation(forProperty("address"), inits.get("address")) : null;
        this.applicationDetail = inits.isInitialized("applicationDetail") ? new QApplicationDetail(forProperty("applicationDetail"), inits.get("applicationDetail")) : null;
    }

}

