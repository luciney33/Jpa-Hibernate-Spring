package org.example.jpaspring.domain.error;


import org.example.jpaspring.common.Constantes;

public class AppError extends RuntimeException {
    public AppError(String message) {
        super(Constantes.APP_ERROR);
    }
}
