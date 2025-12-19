package org.example.jpaspring.dao;

import org.example.jpaspring.dao.model.JpaTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TypeRepository extends JpaRepository<JpaTypeEntity, Integer> {
}
