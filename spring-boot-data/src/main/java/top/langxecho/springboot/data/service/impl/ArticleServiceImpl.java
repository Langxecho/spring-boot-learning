package top.langxecho.springboot.data.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.langxecho.springboot.data.entity.Article;
import top.langxecho.springboot.data.responsitory.ArticleResponsitory;
import top.langxecho.springboot.data.service.ArticleService;

import java.util.List;
import java.util.Optional;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/8 14:24
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleResponsitory articleResponsitory;
    @Override
    public Article saveArticle(Article article) {
        articleResponsitory.save(article);
        return article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleResponsitory.deleteById(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleResponsitory.save(article);
    }

    @Override
    public Article getArticle(Long id) {
        Optional<Article> optionalArticle = articleResponsitory.findById(id);
        return optionalArticle.orElse(null);
    }

    @Override
    public List<Article> getAll() {
        return articleResponsitory.findAll();
    }
}
