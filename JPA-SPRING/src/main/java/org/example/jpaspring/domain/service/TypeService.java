//package org.example.jpaspring.domain.service;
//
//import lombok.Data;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Data
//@Service
//public class TypeService {
//    private final TypeRepository typeRepository;
//    private final MapTypeDtoEntity mapper;
//
//    public TypeService(TypeRepository typeRepository, MapTypeDtoEntity mapper) {
//        this.typeRepository = typeRepository;
//        this.mapper = mapper;
//    }
//
//    public List<TypeDTO> getAllTypes() {
//        List<TypeEntity> typeEntities = typeRepository.getAllTypes();
//        return mapper.entityToDtoList(typeEntities);
//    }
//}
