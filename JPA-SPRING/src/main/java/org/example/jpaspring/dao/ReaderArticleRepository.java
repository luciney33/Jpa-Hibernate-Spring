package org.example.jpaspring.dao;


import org.example.jpaspring.dao.model.JpaReadArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReaderArticleRepository extends JpaRepository<JpaReadArticleEntity, Integer> {
    List<JpaReadArticleEntity> findAllByIdArticle(int idArticle);

    Optional<JpaReadArticleEntity> findByReaderIdReaderAndIdArticle(int idReader, int idArticle);
}
