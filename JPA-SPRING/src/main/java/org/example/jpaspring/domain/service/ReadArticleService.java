package org.example.jpaspring.domain.service;

import newspaperoot.dao.ReaderArticleRepository;
import newspaperoot.dao.model.ReadArticleEntity;
import newspaperoot.domain.mappers.MapReadArticleDtoEntity;
import newspaperoot.domain.model.ReaderArticleDTO;
import org.springframework.stereotype.Service;

@Service
public class ReadArticleService {
    private final ReaderArticleRepository rActRepository;
    private final MapReadArticleDtoEntity mapper;

    public ReadArticleService(ReaderArticleRepository rActRepository, MapReadArticleDtoEntity mapper) {
        this.rActRepository = rActRepository;
        this.mapper = mapper;
    }

    public int add(ReaderArticleDTO dto) {
        ReadArticleEntity entity = mapper.dtoToEntity(dto);
        return rActRepository.add(entity);
    }

    public ReaderArticleDTO update(ReaderArticleDTO dto) {
        ReadArticleEntity entity = mapper.dtoToEntity(dto);
        rActRepository.update(entity);
        return dto;
    }
    public boolean delete(ReaderArticleDTO readerArticleDTO) {
        ReadArticleEntity entity = mapper.dtoToEntity(readerArticleDTO);
        return rActRepository.delete(entity);
    }
}
