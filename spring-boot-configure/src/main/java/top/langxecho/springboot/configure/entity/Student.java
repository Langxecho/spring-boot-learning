package top.langxecho.springboot.configure.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/23 17:52
 */
@Component
@Data
@ConfigurationProperties(prefix = "student")
public class Student {
    private String name;
    private int age;
    private boolean happy;
    private String birth;
    private Map<String,String> map;
    private List<String> list;
    private Dog dog;
}
