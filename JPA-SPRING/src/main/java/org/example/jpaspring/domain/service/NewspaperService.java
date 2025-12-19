package org.example.jpaspring.domain.service;

import lombok.Data;
import org.example.jpaspring.dao.NewspaperRepository;
import org.example.jpaspring.dao.model.JpaNewspaperEntity;
import org.example.jpaspring.domain.model.NewsPaperDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class NewspaperService {
    private final NewspaperRepository newspaperRepository;

    public NewspaperService(NewspaperRepository newspaperRepository) {
        this.newspaperRepository = newspaperRepository;
    }

    public List<NewsPaperDTO> getAllNewspapers() {
        List<JpaNewspaperEntity> newspapers = newspaperRepository.findAll();
        List<NewsPaperDTO> newspapersDTOs = new ArrayList<>();
        newspapers.forEach(newspaper -> {
            newspapersDTOs.add(new NewsPaperDTO(newspaper.getId(), newspaper.getName()));
        });

        return newspapersDTOs;

    }
}
