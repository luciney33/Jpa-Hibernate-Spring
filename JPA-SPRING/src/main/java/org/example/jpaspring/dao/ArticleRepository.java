package org.example.jpaspring.dao;

import org.example.jpaspring.dao.model.JpaArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<JpaArticleEntity, Integer> {
}
