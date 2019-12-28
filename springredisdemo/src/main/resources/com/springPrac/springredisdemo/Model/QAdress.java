package com.springPrac.springredisdemo.Model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAdress is a Querydsl query type for Adress
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAdress extends EntityPathBase<Adress> {

    private static final long serialVersionUID = -1533722232L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAdress adress = new QAdress("adress");

    public final NumberPath<Long> address_cd = createNumber("address_cd", Long.class);

    public final StringPath city = createString("city");

    public final QLocation location;

    public final StringPath type = createString("type");

    public final NumberPath<Integer> zip_cd = createNumber("zip_cd", Integer.class);

    public QAdress(String variable) {
        this(Adress.class, forVariable(variable), INITS);
    }

    public QAdress(Path<? extends Adress> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAdress(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAdress(PathMetadata metadata, PathInits inits) {
        this(Adress.class, metadata, inits);
    }

    public QAdress(Class<? extends Adress> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.location = inits.isInitialized("location") ? new QLocation(forProperty("location"), inits.get("location")) : null;
    }

}

