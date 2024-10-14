package top.langxecho.springboot.configure.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import top.langxecho.springboot.configure.entity.User;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/23 14:50
 */
@RestController
@RequestMapping("/api1")
public class UserController {

    @PostMapping("/userValid")
    public String isUserValid(@Valid @RequestBody User user){
        return "用户满足规范";
    }
}
