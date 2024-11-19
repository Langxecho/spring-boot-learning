package top.langxecho.springboot.websocket.data.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.langxecho.springboot.websocket.data.entity.Article;
@Repository
public interface ArticleResponsitory extends JpaRepository<Article,Long> {

}
