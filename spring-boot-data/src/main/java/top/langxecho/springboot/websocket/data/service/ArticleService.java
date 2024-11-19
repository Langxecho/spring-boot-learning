package top.langxecho.springboot.websocket.data.service;

import org.springframework.stereotype.Service;
import top.langxecho.springboot.websocket.data.entity.Article;

import java.util.List;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/8 14:23
 */
@Service
public interface ArticleService {
    Article saveArticle(Article article);

    void deleteArticle(Long id);

    void updateArticle(Article article);

    Article getArticle(Long id);

    List<Article> getAll();
}
