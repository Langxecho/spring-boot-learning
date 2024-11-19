package top.langxecho.springboot.websocket.thymeleaf.quickstart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/2 18:45
 */
@Data
@AllArgsConstructor
public class User {
    public long id;
    public String name;
    public int age;

}
