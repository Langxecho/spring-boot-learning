package top.langxecho.springboot.configure.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/23 13:53
 */
@Data
@Component
public class Server {
    @Value("${server.host}")
    String host;
    @Value("${server.port}")
    int port;
    @Value("${server.context-path}")
    String contextPath;
}
