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
@NamedQuery(name = "GET_ALL_READERS",
        query = Queries.GET_ALL_READERS)

@NamedQuery(name = "GET_ALL_READERS_BY_ARTICLEID",
        query = Queries.GET_ALL_READERS_BY_ARTICLEID)

@NamedQuery(name = "GET_READER_BYID",
        query = Queries.GET_READER_BYID)
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
