package org.example.jpaspring.domain.error;


import org.example.jpaspring.common.Constantes;

public final class FOREIGN_KEY_ERROR extends DatabaseError {
    public FOREIGN_KEY_ERROR() {
        super(Constantes.FOREIGN_KEY_ERROR);
    }
}