package top.langxecho.zhihu.api;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/14 14:05
 */
@MapperScan("top.langxecho.zhihu.api.mapper")
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}