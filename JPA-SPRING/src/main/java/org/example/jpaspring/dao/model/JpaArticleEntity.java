package org.example.jpaspring.dao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Article")
public class JpaArticleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_article")
    private int id;

    @Column(name = "name_article")
    private String name;

    @Column(name = "id_newspaper")
    private int nPaperId;

    @ManyToOne
    @JoinColumn (name = "id_type")
    private JpaTypeEntity type;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<JpaReadArticleEntity> readArticles;

}
