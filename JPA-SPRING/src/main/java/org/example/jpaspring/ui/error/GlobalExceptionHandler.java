package org.example.jpaspring.ui.error;

import org.example.jpaspring.domain.error.DUPLICATED_USERNAME;
import org.example.jpaspring.domain.error.FOREIGN_KEY_ERROR;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DUPLICATED_USERNAME.class)
    public ResponseEntity<String> handleForeignKetException(DUPLICATED_USERNAME e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
    @ExceptionHandler(FOREIGN_KEY_ERROR.class)
    public ResponseEntity<String> handleForeignKetException(FOREIGN_KEY_ERROR e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
}
