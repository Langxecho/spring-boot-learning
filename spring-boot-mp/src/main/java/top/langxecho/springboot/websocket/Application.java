package top.langxecho.springboot.websocket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/14 13:45
 */

@SpringBootApplication
@MapperScan(basePackages = {"top.langxecho.springboot.mapper"})
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}