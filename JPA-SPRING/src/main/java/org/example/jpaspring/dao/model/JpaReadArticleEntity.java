package org.example.jpaspring.dao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ReadArticle")
public class JpaReadArticleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_reader")
    private JpaReaderEntity reader;

    @ManyToOne
    @JoinColumn(name = "id_article")
    private JpaArticleEntity article;

    @Column
    private int rating;
}
