package org.example.jpaspring.ui;

import org.example.jpaspring.domain.model.ReaderArticleDTO;
import org.example.jpaspring.domain.model.ReaderDTO;
import org.example.jpaspring.domain.service.ReadArticleService;
import org.example.jpaspring.domain.service.ReaderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class RestReader {
    private final ReaderService readerService;
    private final ReadArticleService readArticleService;

    public RestReader(ReaderService readerService, ReadArticleService readArticleService) {
        this.readerService = readerService;
        this.readArticleService = readArticleService;
    }

    @GetMapping("/readers")
    public List<ReaderDTO> getAll() {
        return readerService.getAllReaders();
    }
    @GetMapping("/articles/{articleId}/readers")
    public List<ReaderArticleDTO> getReadersByIdArticle(@PathVariable int articleId) {
        return readerService.getReadersByArticle(articleId);
    }

    @GetMapping("/articles/{readerId}/reader")
    public ReaderDTO getReader(@PathVariable int readerId) {
        return readerService.get(readerId);
    }

    @PostMapping("/articles/readers")
    public int addReadArticle(@RequestBody ReaderArticleDTO dto) {
        return readArticleService.add(dto);
    }

    @PutMapping("/articles/readers")
    public void updateReadArticle(@RequestBody ReaderArticleDTO dto) {
        readArticleService.update(dto);
    }


    @DeleteMapping("/articles/readers")
    public void deleteReadArticle(@RequestBody ReaderArticleDTO dto) {
        readArticleService.delete(dto);
    }

}
