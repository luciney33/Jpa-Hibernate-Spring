package org.example.jpaspring.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleDTO {
    private int id;
    private String name;
    private TypeDTO typeUI;
    private int npaperId;
    private double avgRating;

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n----- Articles -----\n")
                .append(" ID   : ").append(id).append("\n")
                .append(" Name : ").append(name).append("\n")
                .append(" Newspaper : ").append(npaperId).append("\n")
                .append(" Type : ").append(typeUI.getId()).append("\n")
                .append(" Avg Rating : ").append(avgRating).append("\n")
                .append("----------------\n");
        return builder.toString();
    }
}
