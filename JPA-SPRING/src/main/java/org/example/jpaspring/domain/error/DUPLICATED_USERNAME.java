package org.example.jpaspring.domain.error;

import newspaperoot.common.Constantes;

public final class DUPLICATED_USERNAME extends DatabaseError {
    public DUPLICATED_USERNAME () {
        super(Constantes.DUPLICATED_USERNAME_ERROR);
    }
}
