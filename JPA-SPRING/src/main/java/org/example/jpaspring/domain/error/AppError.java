package org.example.jpaspring.domain.error;

import newspaperoot.common.Constantes;

public class AppError extends RuntimeException {
    public AppError(String message) {
        super(Constantes.APP_ERROR);
    }
}
