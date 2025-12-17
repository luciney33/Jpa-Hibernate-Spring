package org.example.jpaspring.dao;

import newspaperoot.dao.hibernate.model.JpaCredentialEntity;


public interface CredentialRepository {
    JpaCredentialEntity get(String username);
}
