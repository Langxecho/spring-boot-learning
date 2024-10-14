package top.langxecho.springboot.configure.service;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/23 21:05
 */

import cn.hutool.core.io.FileUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.File;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConfigBackupService {

    @Value("${custom.backup.location}")
    private String configFilePath;

    @PostConstruct
    public void backupConfigFile() {
        File configFile = new File(configFilePath);
        if (configFile.exists()) {
            File backupFile = new File( configFile.getName());
            FileUtil.copy(configFile, backupFile, true);
            log.info("配置文件已备份到：{}", backupFile.getPath());
        } else {
            log.warn("配置文件不存在：{}", configFilePath);
        }
    }
}

