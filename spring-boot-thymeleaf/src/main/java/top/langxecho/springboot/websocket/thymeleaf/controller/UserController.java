package top.langxecho.springboot.websocket.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.langxecho.springboot.websocket.thymeleaf.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/9 15:47
 */
@Controller
public class UserController {
    private final List<User> users = new ArrayList<>();
    @GetMapping("/userList")
    public String userList(Model model){
        model.addAttribute("users",users);
        return "userList";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name, @RequestParam String email){
        Long id = (long) (users.size() + 1);
        User user = new User(id, name, email);
        users.add(user);
        return "redirect:userList";
    }
}
