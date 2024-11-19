package top.langxecho.springboot.websocket.configure.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/23 14:43
 */

@Data
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String id;
    private int phone;

}
