package org.example.jpaspring.domain.model;

import lombok.Data;

//type of article : economia, futbol
@Data

public class TypeDTO {
    private int id;
    private String name;
    public TypeDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n----- Type -----\n")
                .append(" ID   : ").append(id).append("\n")
                .append(" Name : ").append(name).append("\n")
                .append("----------------\n");
        return builder.toString();
    }
}

