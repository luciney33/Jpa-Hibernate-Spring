package org.example.jpaspring.ui;
import org.example.jpaspring.domain.model.NewsPaperDTO;
import org.example.jpaspring.domain.service.NewspaperService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RestNewspaper {
    private final NewspaperService newspaperService;

    public RestNewspaper(NewspaperService newspaperService) {
        this.newspaperService = newspaperService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/newspapers")
    public List<NewsPaperDTO> getAll() {
        return newspaperService.getAllNewspapers();
    }
}

