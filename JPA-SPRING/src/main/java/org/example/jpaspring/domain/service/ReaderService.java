package org.example.jpaspring.domain.service;
import lombok.Data;
import newspaperoot.dao.ArticleRepository;
import newspaperoot.dao.NewspaperRepository;
import newspaperoot.dao.ReaderArticleRepository;
import newspaperoot.dao.ReaderRepository;
import newspaperoot.dao.model.CredentialEntity;
import newspaperoot.dao.model.NewspaperEntity;
import newspaperoot.dao.model.ReadArticleEntity;
import newspaperoot.dao.model.ReaderEntity;
import newspaperoot.dao.model.xml.CredentialEntityXML;
import newspaperoot.dao.model.xml.ReaderEntityXML;
import newspaperoot.dao.xml.XmlReaderRepository;
import newspaperoot.dao.xml.mappers.ReaderXMLMapper;
import newspaperoot.domain.mappers.MapReadArticleDtoEntity;
import newspaperoot.domain.mappers.MapReaderDtoEntity;
import newspaperoot.domain.model.CredentialDTO;
import newspaperoot.domain.model.ReaderArticleDTO;
import newspaperoot.domain.model.ReaderDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final XmlReaderRepository xmlReaderRepository;
    private final ArticleRepository articleRepository;
    private final ReaderArticleRepository readArtRepository;
    private final MapReadArticleDtoEntity mapperReadArticle;
    private final NewspaperRepository newspaperRepository;
    private final ReaderXMLMapper xmlMapper;
    private final MapReaderDtoEntity mapper;

    public ReaderService(ReaderRepository readerRepository, XmlReaderRepository xmlReaderRepository, ArticleRepository articleRepository, ReaderArticleRepository readArtRepository, MapReadArticleDtoEntity mapperReadArticle, NewspaperRepository newspaperRepository, ReaderXMLMapper xmlMapper, MapReaderDtoEntity mapper) {
        this.readerRepository = readerRepository;
        this.xmlReaderRepository = xmlReaderRepository;
        this.articleRepository = articleRepository;
        this.readArtRepository = readArtRepository;
        this.mapperReadArticle = mapperReadArticle;
        this.newspaperRepository = newspaperRepository;
        this.xmlMapper = xmlMapper;
        this.mapper = mapper;
    }

    public List<ReaderDTO> getAllReaders() {
        List<ReaderEntity> readerEntities = readerRepository.getAll();
        return mapper.entityListToDtoList(readerEntities);

    }
    public ReaderDTO get(int id) {
        ReaderEntity reader = readerRepository.get(id);
        return mapper.entityToDto(reader);
    }


    public List<ReaderArticleDTO> getReadersByArticle(int id) {
        readerRepository.deleteAll();

        List<ReaderEntityXML> readersXML = xmlReaderRepository.getAll();

        for (ReaderEntityXML readerXML : readersXML) {

            ReaderEntity reader = xmlMapper.toEntity(readerXML);

            CredentialEntityXML credentialXML = readerXML.getCredentials();
            CredentialEntity credentialEntity = xmlMapper.toCredentialEntity(credentialXML, 0);

            int readerId = readerRepository.save(reader, credentialEntity, credentialEntity != null);

            List<ReadArticleEntity> activities = xmlMapper.toReadActivityEntities(readerXML, readerId, articleRepository);

            for (ReadArticleEntity activity : activities) {
                readArtRepository.add(activity);
            }

        }

        List <ReaderArticleDTO> readArticleDTOS = mapperReadArticle.entityListToDtoList(readArtRepository.getByIdArticle(id));

        for (ReaderArticleDTO readArticle : readArticleDTOS) {

            ReaderEntity reader = readerRepository.get(readArticle.getIdReader());

            readArticle.setNameReader(reader.getName());
            readArticle.setDobReader(reader.getDobReader());

            List <String> newspaperNames = new ArrayList<>();

            List<NewspaperEntity> newspaperEntities = newspaperRepository.getAllByReader(readArticle.getIdReader());

            newspaperEntities.forEach(newspaper -> {
                newspaperNames.add(newspaper.getName());
            });

            readArticle.setRating(readArtRepository.get(readArticle.getIdReader(),id).getRating());
            readArticle.setSubscriptionsReader(newspaperNames);


        }


        return readArticleDTOS;

    }


    public ReaderDTO saveReader(ReaderDTO readerDTO, CredentialDTO credentialDTO, boolean confirmation) {
        ReaderEntity readerEntity = mapper.dtoToEntity(readerDTO);

        CredentialEntity credentialEntity = null;
        if (confirmation && credentialDTO != null) {
            credentialEntity = new CredentialEntity(
                    credentialDTO.getUsername(),
                    credentialDTO.getPassword(),
                    readerEntity.getId()
            );
        }

        readerRepository.save(readerEntity, credentialEntity, confirmation);

        return readerDTO;
    }
    public ReaderDTO deleteReader(ReaderDTO readerDTO) {
        ReaderEntity readerEntity = mapper.dtoToEntity(readerDTO);
        readerRepository.delete(readerEntity);
        return readerDTO;
    }

    public void updateReader(ReaderDTO readerDTO) {
        ReaderEntity readerEntity = mapper.dtoToEntity(readerDTO);
        readerRepository.update(readerEntity);
    }

}
