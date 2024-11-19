package top.langxecho.springboot.websocket.configure.utils;

import com.aliyun.oss.OSS;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import top.langxecho.springboot.websocket.configure.config.OssConfig;

import java.io.InputStream;
import java.util.UUID;

@Component
public class OssUtil {

    @Resource
    private OSS ossClient;

    @Resource
    private OssConfig ossConfig;

    /**
     * 上传文件到阿里云 OSS
     *
     * @param file MultipartFile 文件
     * @return 上传成功后的文件 URL
     */
    public String uploadFile(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String fileExtension = originalFilename != null ? originalFilename.substring(originalFilename.lastIndexOf(".")) : "";
        String fileName = UUID.randomUUID().toString() + fileExtension;

        try {
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(ossConfig.getBucketName(), fileName, inputStream);
            return "https://" + ossConfig.getBucketName() + "." + ossConfig.getEndpoint() + "/" + fileName;
        } catch (Exception e) {
            throw new RuntimeException("文件上传失败", e);
        }
    }
}
