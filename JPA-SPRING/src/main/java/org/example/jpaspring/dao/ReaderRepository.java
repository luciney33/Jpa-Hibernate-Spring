package org.example.jpaspring.dao;

import org.example.jpaspring.dao.model.JpaReaderEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<JpaReaderEntity, Integer> {

}

