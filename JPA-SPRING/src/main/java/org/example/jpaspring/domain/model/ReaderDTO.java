package org.example.jpaspring.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class ReaderDTO {
    private int idReader;
    private String nameReader;
    private LocalDate dobReader;

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n----- Readers -----\n")
                .append(" ID   : ").append(idReader).append("\n")
                .append(" Name : ").append(nameReader).append("\n")
                .append(" Birth Date : ").append(dobReader).append("\n")
                .append("----------------\n");
        return builder.toString();
    }
}

