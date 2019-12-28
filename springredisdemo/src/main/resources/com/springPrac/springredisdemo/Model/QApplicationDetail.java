package com.springPrac.springredisdemo.Model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QApplicationDetail is a Querydsl query type for ApplicationDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QApplicationDetail extends EntityPathBase<ApplicationDetail> {

    private static final long serialVersionUID = -1191253137L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QApplicationDetail applicationDetail = new QApplicationDetail("applicationDetail");

    public final QApplicant applicant;

    public final NumberPath<Long> application_id = createNumber("application_id", Long.class);

    public final QApplicationFee applicationFee;

    public final DatePath<java.time.LocalDate> date_of_submission = createDate("date_of_submission", java.time.LocalDate.class);

    public final StringPath prcess_fee_stat = createString("prcess_fee_stat");

    public final NumberPath<Integer> SLA = createNumber("SLA", Integer.class);

    public final StringPath status = createString("status");

    public QApplicationDetail(String variable) {
        this(ApplicationDetail.class, forVariable(variable), INITS);
    }

    public QApplicationDetail(Path<? extends ApplicationDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QApplicationDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QApplicationDetail(PathMetadata metadata, PathInits inits) {
        this(ApplicationDetail.class, metadata, inits);
    }

    public QApplicationDetail(Class<? extends ApplicationDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.applicant = inits.isInitialized("applicant") ? new QApplicant(forProperty("applicant"), inits.get("applicant")) : null;
        this.applicationFee = inits.isInitialized("applicationFee") ? new QApplicationFee(forProperty("applicationFee"), inits.get("applicationFee")) : null;
    }

}

