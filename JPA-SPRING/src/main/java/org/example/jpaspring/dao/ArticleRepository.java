package org.example.jpaspring.dao;

import org.example.jpaspring.dao.model.JpaArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<JpaArticleEntity, Integer> {
    List<JpaArticleEntity> getAll();
    JpaArticleEntity get(int id);
    int save(JpaArticleEntity article);
    void delete(JpaArticleEntity article, boolean confirmation);
    void update(JpaArticleEntity article);

}
