package top.langxecho.springboot.websocket.configure.controller;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/23 21:06
 */


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.langxecho.springboot.websocket.configure.service.ConfigBackupService;

@RestController
@AllArgsConstructor
public class ConfigBackupController {

    private final ConfigBackupService configBackupService;

    @GetMapping("/backup")
    public void backupConfig() {
        configBackupService.backupConfigFile();
    }
}

