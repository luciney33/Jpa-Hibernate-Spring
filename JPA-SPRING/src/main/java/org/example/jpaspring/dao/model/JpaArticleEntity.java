package org.example.jpaspring.dao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.jpaspring.dao.utilities.Queries;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Article")

@NamedQueries({
        @NamedQuery(name = "GET_ALL_ARTICLES",
        query = Queries.GET_ALL_ARTICLES),
       @NamedQuery(name = "DELETE_READARTICLE_BY_ARTICLEID", query = Queries.DELETE_READARTICLE_BY_ARTICLEID)
})

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



}


