package top.langxecho.springboot.configure.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import jakarta.annotation.Resource;
import top.langxecho.springboot.configure.utils.OssUtil;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/oss")
public class OssController {

    @Resource
    private OssUtil ossUtil;

    /**
     * 上传文件接口
     *
     * @param file 文件
     * @return 返回文件的URL
     */
    @PostMapping("/upload")
    public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile file) {
        String fileUrl = ossUtil.uploadFile(file);
        Map<String, Object> response = new HashMap<>();
        response.put("fileUrl", fileUrl);
        return response;
    }
}
