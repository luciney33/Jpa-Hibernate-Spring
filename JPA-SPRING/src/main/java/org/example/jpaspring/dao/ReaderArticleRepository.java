package org.example.jpaspring.dao;


import org.example.jpaspring.dao.model.JpaReadArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReaderArticleRepository extends JpaRepository<JpaReadArticleEntity, Integer> {
    List<JpaReadArticleEntity> findAllById_article(int id_article);
}
