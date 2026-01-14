package org.example.jpaspring.ui;



import org.example.jpaspring.domain.model.ArticleDTO;
import org.example.jpaspring.domain.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class RestArticle {
    private final ArticleService articleService;
    public RestArticle(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles")
    public List<ArticleDTO> getArticles() {
        return articleService.getAllArticles();
    }

    @PostMapping("/articles")
    public ArticleDTO addArticle(@RequestBody ArticleDTO articleDTO) {
        return articleService.saveArticle(articleDTO);
    }

    @PutMapping("/articles")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateArticle(@RequestBody ArticleDTO articleDTO) {
        articleService.updateArticle(articleDTO);
    }

    @DeleteMapping("/articles/{articleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArticle(@PathVariable int articleId) {
        articleService.deleteArticle(articleId);
    }
}