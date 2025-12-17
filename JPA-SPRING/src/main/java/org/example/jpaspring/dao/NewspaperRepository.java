package org.example.jpaspring.dao;

import newspaperoot.dao.hibernate.model.JpaNewspaperEntity;

import java.util.List;

public interface NewspaperRepository {
    List<JpaNewspaperEntity> getAll();
}
