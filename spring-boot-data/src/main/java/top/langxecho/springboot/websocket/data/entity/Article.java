package top.langxecho.springboot.websocket.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/8 14:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "t_article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 32)
    private String author;

    @Column(nullable = false, unique = true, length = 32)
    private String title;

    @Column(length = 512)
    private String content;

}
