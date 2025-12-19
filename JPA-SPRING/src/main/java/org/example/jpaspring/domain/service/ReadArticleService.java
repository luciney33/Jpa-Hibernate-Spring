package org.example.jpaspring.domain.service;


import org.example.jpaspring.dao.ArticleRepository;
import org.example.jpaspring.dao.ReaderArticleRepository;
import org.example.jpaspring.dao.ReaderRepository;
import org.example.jpaspring.dao.model.JpaArticleEntity;
import org.example.jpaspring.dao.model.JpaReadArticleEntity;
import org.example.jpaspring.dao.model.JpaReaderEntity;
import org.example.jpaspring.domain.model.ReaderArticleDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReadArticleService {
    private final ReaderArticleRepository rActRepository;
    private final ArticleRepository articleRepository;
    private final ReaderRepository readerRepository;

    public ReadArticleService(ReaderArticleRepository rActRepository, ArticleRepository articleRepository, ReaderRepository readerRepository) {
        this.rActRepository = rActRepository;
        this.articleRepository = articleRepository;
        this.readerRepository = readerRepository;
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
        JpaReadArticleEntity found = rActRepository.findByReaderIdReaderAndIdArticle(
                dto.getIdReader(),
                dto.getIdArticle()
        ).orElse(null);

        if (found != null) {
            found.setRating(dto.getRating());
            rActRepository.save(found);
            return dto;
        }
        throw new RuntimeException("Rating not found for readerID: " + dto.getIdReader() + " and articleID: " + dto.getIdArticle());
    }

    public boolean delete(ReaderArticleDTO dto) {
        JpaReadArticleEntity found = rActRepository.findByReaderIdReaderAndIdArticle(
                dto.getIdReader(),
                dto.getIdArticle()
        ).orElse(null);

        if (found != null) {
            rActRepository.delete(found);
            return true;
        }
        return false;
    }
}
