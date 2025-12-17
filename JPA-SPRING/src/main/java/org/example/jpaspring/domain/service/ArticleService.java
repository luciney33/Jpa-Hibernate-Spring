package org.example.jpaspring.domain.service;

import lombok.Data;
import newspaperoot.dao.ArticleRepository;
import newspaperoot.dao.ReaderArticleRepository;
import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.dao.model.ReadArticleEntity;
import newspaperoot.domain.mappers.MapArticleDtoEntity;
import newspaperoot.domain.model.ArticleDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Data
@Service
public class ArticleService {
    private final ReaderArticleRepository readerArticleRepository;
    private final ArticleRepository articleRepository;
    private final MapArticleDtoEntity mapper;

    public ArticleService(ReaderArticleRepository readerArticleRepository, ArticleRepository articleRepository, MapArticleDtoEntity mapper ) {
        this.readerArticleRepository = readerArticleRepository;
        this.articleRepository = articleRepository;
        this.mapper = mapper;
    }


    public List<ArticleDTO> getAllArticles() {
        List<ArticleEntity> articles = articleRepository.getAll();
        Map<Integer, Double> avgByArticleId = readerArticleRepository.getAllByArticleId().stream()
                .collect(Collectors.toMap(ReadArticleEntity::getIdArticle,
                        r -> (double) r.getRating()));
        return articles.stream()
                .map(entity -> {
                    ArticleDTO dto = mapper.entityToDto(entity);
                    dto.setAvgRating(avgByArticleId.getOrDefault(entity.getId(), 0d));
                    return dto;
                })
                .collect(Collectors.toList());
    }


    public ArticleDTO saveArticle(ArticleDTO articleDTO) {
        ArticleEntity articleEntity = mapper.dtoToEntity(articleDTO);
        int id = articleRepository.save(articleEntity);
        articleDTO.setId(id);
        return articleDTO;
    }

    public void updateArticle(ArticleDTO articleDTO) {
        ArticleEntity articleEntity = mapper.dtoToEntity(articleDTO);
        articleRepository.update(articleEntity);
    }

    public void deleteArticle(int articleId, boolean confirmation) {
        articleRepository.delete(articleId,confirmation);
    }
}
