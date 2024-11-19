package top.langxecho.springboot.websocket.filter_interceptor.controller;

import cloud.tianai.captcha.application.ImageCaptchaApplication;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.langxecho.springboot.websocket.filter_interceptor.utils.MinIoTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/11/4 13:48
 */
@RestController
@Slf4j
public class TestController {
    DateFormat df = new SimpleDateFormat("yyyyMMdd");

    @Resource
    private ImageCaptchaApplication application;

    @Resource
    private MinIoTemplate minIoTemplate;
    @GetMapping("test")
    public String test(){
        return "已请求";
    }
    @PostMapping("/minio")
    public String minioUpload(HttpServletRequest request) {
        MultipartFile file = (MultipartFile) request.getAttribute("file");
        if (file != null) {
            String url;
            String originalFilename = file.getOriginalFilename();
            assert originalFilename != null;
            String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
            try {
                url = minIoTemplate.putObject("langxecho", "test/" + UUID.randomUUID() + suffixName, file.getInputStream());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return url;
        } else {
            return "文件不能为空";
        }
    }
    }



