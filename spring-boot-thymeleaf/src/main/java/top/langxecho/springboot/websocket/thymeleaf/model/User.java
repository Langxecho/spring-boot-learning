package top.langxecho.springboot.websocket.thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/9 15:45
 */
@Data
@AllArgsConstructor
public class User {
    long id;
    String username;
    String email;
}
