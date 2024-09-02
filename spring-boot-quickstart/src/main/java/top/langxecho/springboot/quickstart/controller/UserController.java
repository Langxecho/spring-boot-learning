package top.langxecho.springboot.quickstart.controller;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.langxecho.springboot.quickstart.service.UserService;

import java.util.List;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/2 18:53
 */
@RestController("/users")
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/adults")
    public List<String> getAdultsUserName(){
        return userService.getAdultUserName();
    }
}
