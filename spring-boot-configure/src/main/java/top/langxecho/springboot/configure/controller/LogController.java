package top.langxecho.springboot.configure.controller;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/23 20:54
 */

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import top.langxecho.springboot.configure.service.LogService;

@RestController
@AllArgsConstructor
public class LogController {

    private final LogService logService;

    @GetMapping("/log")
    public void logMsg() {
        logService.logMessage();
    }
}

