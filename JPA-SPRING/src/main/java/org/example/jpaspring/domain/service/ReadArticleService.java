package org.example.jpaspring.domain.service;


import org.example.jpaspring.dao.ArticleRepository;
import org.example.jpaspring.dao.ReaderArticleRepository;
import org.example.jpaspring.dao.ReaderRepository;
import org.example.jpaspring.dao.model.JpaArticleEntity;
import org.example.jpaspring.dao.model.JpaReadArticleEntity;
import org.example.jpaspring.dao.model.JpaReaderEntity;
import org.example.jpaspring.domain.mappers.MapReadArticleDtoEntity;
import org.example.jpaspring.domain.model.ReaderArticleDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReadArticleService {
    private final ReaderArticleRepository rActRepository;
    private final ArticleRepository articleRepository;
    private final ReaderRepository readerRepository;
    private final MapReadArticleDtoEntity mapper;

    public ReadArticleService(ReaderArticleRepository rActRepository, ArticleRepository articleRepository, ReaderRepository readerRepository, MapReadArticleDtoEntity mapper) {
        this.rActRepository = rActRepository;
        this.articleRepository = articleRepository;
        this.readerRepository = readerRepository;
        this.mapper = mapper;
    }

    public int add(ReaderArticleDTO dto) {
        JpaReaderEntity reader = readerRepository.findById(dto.getIdReader()).orElse(null);
        JpaArticleEntity article = articleRepository.findById(dto.getIdArticle()).orElse(null);

        if (reader == null || article == null) {
            throw new RuntimeException("Reader or Article not found");
        }

        JpaReadArticleEntity readArticle = new JpaReadArticleEntity(
                0,
                reader,
                article.getId(),
                dto.getRating()
        );
        JpaReadArticleEntity saved = rActRepository.save(readArticle);
        return saved.getId();
    }

    public ReaderArticleDTO update(ReaderArticleDTO dto) {
        List<JpaReadArticleEntity> allReadArticles = rActRepository.findAll();
        JpaReadArticleEntity found = allReadArticles.stream()
                .filter(ra -> ra.getReader() != null && ra.getReader().getId_reader() == dto.getIdReader())
                .filter(ra -> ra.getId_article() != null && ra.getId_article() == dto.getIdArticle())
                .findFirst()
                .orElse(null);

        if (found != null) {
            found.setValue(readArticleDTO.getRating());
            readArticleRepository.save(found);
            return found.getId();
        }
        throw new RuntimeException("Rating not found for readerID: " + readArticleDTO.getIdReader() + " and articleID: " + readArticleDTO.getIdArticle());
    }
    rActRepository.update(entity);
        return dto;
    }
    public boolean delete(ReaderArticleDTO readerArticleDTO) {
        ReadArticleEntity entity = mapper.dtoToEntity(readerArticleDTO);
        return rActRepository.delete(entity);
    }
}
