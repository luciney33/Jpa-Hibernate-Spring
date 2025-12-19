package org.example.jpaspring.dao;


import org.example.jpaspring.dao.model.JpaReadArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReaderArticleRepository extends JpaRepository<JpaReadArticleEntity, Integer> {
    List<JpaReadArticleEntity> findAllById_article(int id_article);

    // Buscar por reader y article
    Optional<JpaReadArticleEntity> findByReader_Id_readerAndId_article(int id_reader, int id_article);
}
