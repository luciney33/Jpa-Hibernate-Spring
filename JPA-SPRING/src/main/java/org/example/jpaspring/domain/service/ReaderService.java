package org.example.jpaspring.domain.service;
import lombok.Data;
import org.example.jpaspring.dao.ArticleRepository;
import org.example.jpaspring.dao.NewspaperRepository;
import org.example.jpaspring.dao.ReaderArticleRepository;
import org.example.jpaspring.dao.ReaderRepository;
import org.example.jpaspring.dao.model.JpaCredentialEntity;
import org.example.jpaspring.dao.model.JpaReadArticleEntity;
import org.example.jpaspring.dao.model.JpaReaderEntity;
import org.example.jpaspring.domain.model.CredentialDTO;
import org.example.jpaspring.domain.model.ReaderArticleDTO;
import org.example.jpaspring.domain.model.ReaderDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
@Transactional
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final ArticleRepository articleRepository;
    private final ReaderArticleRepository readArtRepository;
    private final NewspaperRepository newspaperRepository;

    public ReaderService(ReaderRepository readerRepository, ArticleRepository articleRepository,
                        ReaderArticleRepository readArtRepository, NewspaperRepository newspaperRepository){
        this.readerRepository = readerRepository;
        this.articleRepository = articleRepository;
        this.readArtRepository = readArtRepository;
        this.newspaperRepository = newspaperRepository;
    }

    public List<ReaderDTO> getAllReaders() {
        List<JpaReaderEntity> readers = readerRepository.findAll();
        List<ReaderDTO> readerDTOS = new ArrayList<>();
        readers.forEach(reader -> {
            readerDTOS.add(new ReaderDTO(reader.getIdReader(), reader.getName(), reader.getBirthDate()));
        });

        return readerDTOS;

    }
    public ReaderDTO get(int id) {
        JpaReaderEntity reader = readerRepository.findById(id).orElse(null);
        if (reader == null) {
            return null;
        }
        return new ReaderDTO(reader.getIdReader(), reader.getName(), reader.getBirthDate());
    }


    public List<ReaderArticleDTO> getReadersByArticle(int articleId) {
        List<JpaReadArticleEntity> readArticleEntities = readArtRepository.findAllByArticle_Id(articleId);
        List<ReaderArticleDTO> readArticleDTOS = new ArrayList<>();

        for (JpaReadArticleEntity readArticleEntity : readArticleEntities) {
            JpaReaderEntity reader = readArticleEntity.getReader();

            if (reader == null) {
                continue;
            }

            List<String> newspaperNames = new ArrayList<>();
            if (reader.getSubscriptionsReader() != null) {
                reader.getSubscriptionsReader().forEach(subscription -> {
                    if (subscription.getNPaperId() != null) {
                        newspaperNames.add(subscription.getNPaperId().getName());
                    }
                });
            }

            ReaderArticleDTO dto = new ReaderArticleDTO(
                    readArticleEntity.getId(),
                    reader.getIdReader(),
                    reader.getName(),
                    reader.getBirthDate(),
                    newspaperNames,
                    readArticleEntity.getRating()
            );

            readArticleDTOS.add(dto);
        }


        return readArticleDTOS;
    }


    public int saveReader(ReaderDTO readerDTO, CredentialDTO credentialDTO) {
        JpaReaderEntity readerEntity = new JpaReaderEntity();
        readerEntity.setName(readerDTO.getNameReader());
        readerEntity.setBirthDate(readerDTO.getDobReader());

        JpaCredentialEntity credentialEntity = new JpaCredentialEntity();
        credentialEntity.setUsername(credentialDTO.getUsername());
        credentialEntity.setPassword(credentialDTO.getPassword());
        credentialEntity.setReaderId(readerEntity);

        credentialEntity.setReaderId(readerEntity);

        JpaReaderEntity saved = readerRepository.save(readerEntity);
        return saved.getIdReader();
    }
    public void deleteReader(int id, boolean confirmation) {
        JpaReaderEntity readerEntity = readerRepository.findById(id).orElse(null);
        if (readerEntity != null) {
            readerRepository.delete(readerEntity);
        } else {
            System.err.println("The reader with id " + id + " does not exist.");
        }
    }

}
