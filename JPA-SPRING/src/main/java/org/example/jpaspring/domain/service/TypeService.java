package org.example.jpaspring.domain.service;

import lombok.Data;
import org.example.jpaspring.dao.TypeRepository;
import org.example.jpaspring.dao.model.JpaTypeEntity;
import org.example.jpaspring.domain.model.TypeDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class TypeService {
    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<TypeDTO> getAllTypes() {
        List<JpaTypeEntity> types = typeRepository.findAll();
        List<TypeDTO> typeDTOs = new ArrayList<>();
        types.forEach(type -> {
            typeDTOs.add(new TypeDTO(type.getId(), type.getDescription()));
        });

        return typeDTOs;
    }
}
