package top.langxecho.springboot.configure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/23 13:50
 */

@SpringBootApplication
//@ImportResource(locations = {"classpath:beans.xml"})
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
