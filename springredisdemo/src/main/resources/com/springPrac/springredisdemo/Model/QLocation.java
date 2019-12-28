package com.springPrac.springredisdemo.Model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocation is a Querydsl query type for Location
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLocation extends EntityPathBase<Location> {

    private static final long serialVersionUID = 1997260359L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocation location = new QLocation("location");

    public final ListPath<Adress, QAdress> addressList = this.<Adress, QAdress>createList("addressList", Adress.class, QAdress.class, PathInits.DIRECT2);

    public final QApplicant applicant;

    public final NumberPath<Integer> loc_cd = createNumber("loc_cd", Integer.class);

    public QLocation(String variable) {
        this(Location.class, forVariable(variable), INITS);
    }

    public QLocation(Path<? extends Location> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLocation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLocation(PathMetadata metadata, PathInits inits) {
        this(Location.class, metadata, inits);
    }

    public QLocation(Class<? extends Location> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.applicant = inits.isInitialized("applicant") ? new QApplicant(forProperty("applicant"), inits.get("applicant")) : null;
    }

}

