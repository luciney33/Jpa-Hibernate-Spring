package org.example.jpaspring.domain.service;

import lombok.Data;
import org.example.jpaspring.dao.ArticleRepository;
import org.example.jpaspring.dao.ReaderArticleRepository;
import org.example.jpaspring.dao.model.JpaArticleEntity;
import org.example.jpaspring.dao.model.JpaReadArticleEntity;
import org.example.jpaspring.dao.model.JpaTypeEntity;
import org.example.jpaspring.domain.error.FOREIGN_KEY_ERROR;
import org.example.jpaspring.domain.model.ArticleDTO;
import org.example.jpaspring.domain.model.TypeDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;



@Data
@Service
@Transactional
public class ArticleService {
    private final ReaderArticleRepository readerArticleRepository;
    private final ArticleRepository articleRepository;

    public ArticleService(ReaderArticleRepository readerArticleRepository, ArticleRepository articleRepository ) {
        this.readerArticleRepository = readerArticleRepository;
        this.articleRepository = articleRepository;
    }


    public List<ArticleDTO> getAllArticles() {
        List<JpaArticleEntity> articles = articleRepository.findAll();
        List<ArticleDTO> articleDTOs = new ArrayList<>();

        articles.forEach(article -> {
            double avgRating = readerArticleRepository.findAllByArticle_Id(article.getId()).stream()
                    .mapToInt(JpaReadArticleEntity::getRating)
                    .average()
                    .orElse(0.0);

            TypeDTO typeDTO = article.getType() != null
                    ? new TypeDTO(article.getType().getId(), article.getType().getDescription())
                    : null;
            articleDTOs.add(new ArticleDTO(article.getId(), article.getName(), typeDTO, article.getNPaperId(), avgRating));
        });

        return articleDTOs;
    }


    public ArticleDTO saveArticle(ArticleDTO articleDTO) {
        TypeDTO typeDTO = articleDTO.getTypeUI();
        if (typeDTO == null) {
            throw new IllegalArgumentException("El artículo debe tener un tipo seleccionado");
        }

        JpaTypeEntity type = new JpaTypeEntity(typeDTO.getId(), typeDTO.getName(), null);

        JpaArticleEntity articleEntity = new JpaArticleEntity(
                0,
                articleDTO.getName(),
                articleDTO.getNpaperId(),
                type,
                null
        );

        JpaArticleEntity saved = articleRepository.save(articleEntity);
        articleDTO.setId(saved.getId());
        return articleDTO;
    }

    public void updateArticle(ArticleDTO articleDTO) {
        TypeDTO typeDTO = articleDTO.getTypeUI();
        if (typeDTO == null) {
            throw new IllegalArgumentException("El artículo debe tener un tipo seleccionado");
        }

        JpaTypeEntity type = new JpaTypeEntity(typeDTO.getId(), typeDTO.getName(), null);

        JpaArticleEntity articleEntity = new JpaArticleEntity(
                articleDTO.getId(),
                articleDTO.getName(),
                articleDTO.getNpaperId(),
                type,
                null
        );

        articleRepository.save(articleEntity);
    }

    public void deleteArticle(int articleId) {
        JpaArticleEntity article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("Artículo no encontrado"));

        List<JpaReadArticleEntity> readArticles = readerArticleRepository.findAllByArticle_Id(articleId);

        if (!readArticles.isEmpty()) {
            throw new FOREIGN_KEY_ERROR();
        }

        articleRepository.delete(article);
    }
}
