package top.langxecho.springboot.websocket.configure.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import top.langxecho.springboot.websocket.configure.loader.CustomYamlPropertyLoader;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/23 14:15
 */
@Data
@ConfigurationProperties(prefix = "family")
@PropertySource(value = {"classpath:family.yml"},factory = CustomYamlPropertyLoader.class)
@Validated
@Component
public class Family {
    @Length(min = 10,message = "名称必须大于10")
    private String familyName;
    private String father;
    private String mother;
    private String child;
    private  Integer age;
}
