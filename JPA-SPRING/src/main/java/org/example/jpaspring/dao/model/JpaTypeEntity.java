package org.example.jpaspring.dao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Type")
@NamedQueries({ @NamedQuery(name = "GET_ALL_TYPES",
        query = "from JpaTypeEntity") })
public class JpaTypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_type")
    private int id;

    @Column
    private String name;

    @Column
    private String description;

}
