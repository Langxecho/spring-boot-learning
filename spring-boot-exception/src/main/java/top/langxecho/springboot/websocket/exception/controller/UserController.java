package top.langxecho.springboot.websocket.exception.controller;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.langxecho.springboot.websocket.exception.entity.User;
import top.langxecho.springboot.websocket.exception.result.Result;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/15 14:07
 */

@RestController
public class UserController {
    @PostMapping("/user/add")
    public Result<?> addUser(@Valid @RequestBody User user, BindingResult
            bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return Result.ok(user);
    }
}