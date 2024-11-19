package top.langxecho.springboot.websocket.file.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/31 14:36
 */

@Configuration
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "aliyun.oss")
@Data
public class OssConfig {
    private String endpoint;
    private String bucket;
    private String dir;
    private String host;
    private String ak;
    private String secret;
}