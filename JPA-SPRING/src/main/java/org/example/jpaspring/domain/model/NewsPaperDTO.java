package org.example.jpaspring.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsPaperDTO {
    private int id;
    private String name;

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n----- Newspaper -----\n")
                .append(" ID   : ").append(id).append("\n")
                .append(" Name : ").append(name).append("\n")
                .append("----------------\n");
        return builder.toString();
    }

}
