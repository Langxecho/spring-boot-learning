package top.langxecho.springboot.data.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.langxecho.springboot.data.Application;
import top.langxecho.springboot.data.entity.Article;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = Application.class)
@Slf4j
public class ArticleServiceImplTest {
    @Resource
    private ArticleServiceImpl articleService;
    @Test
    void saveArticle() {
        Article article = Article.builder()
                .title("SpringBoot")
                .author("张三")
                .content("SpringBoot从入门到精通")
                .build();

        Article savedArticle = articleService.saveArticle(article);
        log.info(String.valueOf(savedArticle));
    }

    @Test
    void deleteArticle() {
        articleService.deleteArticle(1l);
    }

    @Test
    void updateArticle() {
        Article article = articleService.getArticle(1L);
        article.setTitle("springboot111");
    }

    @Test
    void getArticle() {
        Article article = articleService.getArticle(1L);
        log.info(String.valueOf(article));
    }

    @Test
    void getAll() {
    }
}