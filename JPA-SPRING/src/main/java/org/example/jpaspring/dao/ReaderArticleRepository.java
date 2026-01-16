package org.example.jpaspring.dao;

import org.example.jpaspring.dao.model.JpaReadArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReaderArticleRepository extends JpaRepository<JpaReadArticleEntity, Integer> {
    List<JpaReadArticleEntity> findAllByArticle_Id(int idArticle);
    @Query("select avg(ra.rating) from JpaReadArticleEntity ra where ra.article.id = ?1")
    Double getAvgRatingByArticle_Id(int idArticle);
    JpaReadArticleEntity getByArticle_IdAndReader_IdReader(int idArticle, int idReader);
}
