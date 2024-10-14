package top.langxecho.springboot.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/9 13:54
 */
@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args){
       SpringApplication.run(Application.class, args);
    }

    @PostMapping("/")
    public String hello(@RequestParam int num1,@RequestParam int num2){
        int res = num1 + num2;
        res = res * res;
        return "计算的结果是" + res;
    }
}
