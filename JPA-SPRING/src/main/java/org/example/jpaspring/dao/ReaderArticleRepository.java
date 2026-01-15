package org.example.jpaspring.dao;

import org.example.jpaspring.dao.model.JpaReadArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReaderArticleRepository extends JpaRepository<JpaReadArticleEntity, Integer> {
    List<JpaReadArticleEntity> findAllByArticle_Id(int idArticle);
    JpaReadArticleEntity getByArticle_IdAndReader_IdReader(int idArticle, int idReader);
}
