package org.example.jpaspring.dao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private JpaReaderEntity reader;

    @ManyToOne
    @JoinColumn(name = "id_article")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private JpaArticleEntity article;

    @Column
    private int rating;
}
