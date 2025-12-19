package org.example.jpaspring.dao.model;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "id_reader")
    private int idReader;

    @Column
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany
    @JoinColumn(name = "id_reader")
    private List<JpaSubscribeEntity> subscriptionsReader;

}
