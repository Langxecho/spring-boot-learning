package top.langxecho.springboot.quickstart.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.langxecho.springboot.quickstart.enums.RequestType;
import top.langxecho.springboot.quickstart.service.CustomService;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/2 16:22
 */
@RestController
@RequestMapping("/custom")
public class CustomController {
    @Resource
    CustomService service;

    @GetMapping("/{type}")
    public String getQueryType(@PathVariable RequestType type){
        return service.handleRequest(type);
    }
}
