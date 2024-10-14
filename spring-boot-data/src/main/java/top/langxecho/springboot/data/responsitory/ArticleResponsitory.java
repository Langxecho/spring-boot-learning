package top.langxecho.springboot.data.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.langxecho.springboot.data.entity.Article;
@Repository
public interface ArticleResponsitory extends JpaRepository<Article,Long> {

}
