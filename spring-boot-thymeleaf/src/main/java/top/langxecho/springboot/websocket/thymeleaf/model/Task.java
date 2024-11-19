package top.langxecho.springboot.websocket.thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/9 14:55
 */
@Data
@AllArgsConstructor
public class Task {
    private Long id;
    private String name;
    private Boolean completed;

}
