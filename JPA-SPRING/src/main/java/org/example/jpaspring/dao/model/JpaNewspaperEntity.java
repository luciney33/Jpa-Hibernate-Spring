package org.example.jpaspring.dao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.jpaspring.dao.utilities.Queries;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Newspaper")
@NamedQuery(name = "GET_ALL_NEWSPAPERS",
        query = Queries.GET_ALL_NEWSPAPERS)
public class JpaNewspaperEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_newspaper")
    private int id;

    @Column
    private String name;

    @Column
    private LocalDate date;
}
