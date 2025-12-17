package org.example.jpaspring.domain.mappers;

import newspaperoot.dao.model.ReadArticleEntity;
import newspaperoot.domain.model.ReaderArticleDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MapReadArticleDtoEntity {
    public ReaderArticleDTO entityToDto(ReadArticleEntity entity) {
        return new ReaderArticleDTO(entity.getIdArticle(), entity.getIdReader(),entity.getNameReader(), entity.getDobReader(), entity.getSubscriptionsReader(),entity.getRating());
    }
    public List<ReaderArticleDTO> entityListToDtoList(List<ReadArticleEntity> entities) {
        List<ReaderArticleDTO> dtos = new ArrayList<>();
        for (ReadArticleEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }
    public ReadArticleEntity dtoToEntity(ReaderArticleDTO dto) {
        return new ReadArticleEntity(0, dto.getIdReader(), dto.getIdArticle(), dto.getNameReader(), dto.getDobReader(), dto.getSubscriptionsReader(), dto.getRating());
    }

}
