package org.example.jpaspring.dao.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.jpaspring.dao.utilities.Queries;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Reader")
public class JpaReaderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private int id_reader;

    @Column
    private String name;

    @Column
    private LocalDate birth_date;

    @OneToMany
    @JoinColumn(name = "id_reader")
    private List<JpaSubscribeEntity> subscriptionsReader;


}
