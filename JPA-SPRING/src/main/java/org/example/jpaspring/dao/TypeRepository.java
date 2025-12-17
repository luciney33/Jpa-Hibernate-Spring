package org.example.jpaspring.dao;

import newspaperoot.dao.hibernate.model.JpaTypeEntity;

import java.util.List;

public interface TypeRepository {
    List<JpaTypeEntity> getAllTypes();
}
