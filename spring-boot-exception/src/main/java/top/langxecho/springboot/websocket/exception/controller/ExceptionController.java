package top.langxecho.springboot.websocket.exception.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.langxecho.springboot.websocket.exception.service.ExceptionService;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/15 14:00
 */

@RestController
public class ExceptionController {
    @Resource
    private ExceptionService exceptionService;
    @GetMapping("/articles/{id}")
    public void getArticle(@PathVariable("id") Integer id) {
        if (id == 1) {
            exceptionService.unAuthorizedError();
        } else {
            exceptionService.systemError();
        }
    }
}
