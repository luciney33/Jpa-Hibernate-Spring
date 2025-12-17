package org.example.jpaspring.dao;

import newspaperoot.dao.hibernate.model.JpaReadArticleEntity;

import java.util.List;

public interface ReaderArticleRepository {
    List<JpaReadArticleEntity> getAllByArticleId();
    int save(JpaReadArticleEntity readArticle);
    void update(JpaReadArticleEntity readArticle);
    boolean delete(JpaReadArticleEntity readArticle);
}
