package com.springPrac.springredisdemo.Model.CompositeKeyModel;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QApplicantIdentity is a Querydsl query type for ApplicantIdentity
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QApplicantIdentity extends BeanPath<ApplicantIdentity> {

    private static final long serialVersionUID = 378914545L;

    public static final QApplicantIdentity applicantIdentity = new QApplicantIdentity("applicantIdentity");

    public final NumberPath<Long> applicant_id = createNumber("applicant_id", Long.class);

    public final StringPath identification_num = createString("identification_num");

    public QApplicantIdentity(String variable) {
        super(ApplicantIdentity.class, forVariable(variable));
    }

    public QApplicantIdentity(Path<? extends ApplicantIdentity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QApplicantIdentity(PathMetadata metadata) {
        super(ApplicantIdentity.class, metadata);
    }

}

