package org.example.jpaspring.dao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Subscription")
@IdClass(SubscribeId.class)
public class JpaSubscribeEntity {
    @Id
    @Column(name = "id_reader")
    private int readerId;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_newspaper")
    private JpaNewspaperEntity nPaperId;

    @Column(name = "startdate")
    private LocalDate startDate;

    @Column(name = "enddate")
    private LocalDate endDate;
}
