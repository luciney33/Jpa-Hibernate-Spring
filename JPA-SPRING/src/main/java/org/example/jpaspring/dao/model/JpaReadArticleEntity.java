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
@Table(name = "ReadArticle")
@NamedQueries({
        @NamedQuery(name = "GET_ALL_READARTICLES_BY_ARTICLEID",
                query = Queries.GET_ALL_READARTICLES_BY_ARTICLEID),
        @NamedQuery(name = "UPDATE_RATING",
                query = Queries.UpdateRating),
        @NamedQuery(name = "DELETE_RATING",
                query = Queries.DeleteRating)
})
public class JpaReadArticleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_reader")
    private JpaReaderEntity reader;

    @Column
    private int id_article;

    @Column
    private int rating;
}
