package org.example.jpaspring.domain.service;


import org.example.jpaspring.dao.CredentialRepository;
import org.example.jpaspring.dao.model.JpaCredentialEntity;
import org.example.jpaspring.domain.model.CredentialDTO;
import org.springframework.stereotype.Service;

@Service
public class CredentialService {
    private final CredentialRepository credentialRepository;

    public CredentialService(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    public boolean checkLogin(CredentialDTO credentialDTO) {
        JpaCredentialEntity credentialEntity = credentialRepository.findAll().stream()
                .filter(credential -> credential.getUsername().equals(credentialDTO.getUsername()))
                .findFirst()
                .orElse(null);
        if (credentialEntity == null) {
            return false;
        }
        return credentialEntity.getPassword().equals(credentialDTO.getPassword());
    }
}
