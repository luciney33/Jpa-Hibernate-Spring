package org.example.jpaspring.dao;


import org.example.jpaspring.dao.model.JpaNewspaperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewspaperRepository extends JpaRepository<JpaNewspaperEntity, Integer> {
}
