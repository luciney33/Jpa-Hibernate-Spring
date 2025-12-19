package org.example.jpaspring.dao;

import org.example.jpaspring.dao.model.JpaCredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<JpaCredentialEntity, String> {
}
