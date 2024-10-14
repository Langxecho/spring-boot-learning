package top.langxecho.springboot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/9 14:36
 */
@Controller
public class MessageController {
    @GetMapping("/msg")
    public  String getMsg(Model model){
        model.addAttribute("message","hello mythmeleaf");
        return "msg";
    }
}
