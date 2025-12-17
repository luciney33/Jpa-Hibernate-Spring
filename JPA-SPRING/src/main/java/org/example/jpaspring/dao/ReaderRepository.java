package org.example.jpaspring.dao;

import newspaperoot.dao.hibernate.model.JpaCredentialEntity;
import newspaperoot.dao.hibernate.model.JpaReaderEntity;

import java.util.List;

public interface ReaderRepository {
    List<JpaReaderEntity> getAll();
    JpaReaderEntity get(int id);
    List<JpaReaderEntity> getAllByArticle(int articleId);
    int save(JpaReaderEntity reader, JpaCredentialEntity credential, boolean confirmation);
    boolean delete(JpaReaderEntity reader,  boolean confirmation);
}

