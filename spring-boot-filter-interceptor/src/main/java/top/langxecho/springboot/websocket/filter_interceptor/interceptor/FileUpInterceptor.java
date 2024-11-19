package top.langxecho.springboot.websocket.filter_interceptor.interceptor;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.extra.pinyin.PinyinUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.langxecho.springboot.websocket.filter_interceptor.utils.MinIoTemplate;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/11/4 16:23
 */
@Component
@Slf4j
public class FileUpInterceptor implements HandlerInterceptor {
    @Resource
    private MinIoTemplate minIoTemplate;
    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024; // 5MB
    private static final String[] ALLOWED_TYPES = {
            "image/jpeg",
            "image/png",
            "image/gif",
            "image/bmp",   // BMP 类型
            "image/webp"   // WEBP 类型
    };


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("我被执行了");

            //获取上传文件
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");

        if (file == null || file.isEmpty()) {
            response.setStatus(200);
            response.getWriter().write("The image cannot be empty!");
            return false; // 阻止请求继续处理
        }

            // 文件类型检查
        if (!isAllowedFileType(file.getContentType())) {
            response.setStatus(200);
            response.getWriter().write("Invalid image type!");
            return false;
        }
            // 文件大小限制
        if (file.getSize() > MAX_FILE_SIZE) {
            response.setStatus(200);
            response.getWriter().write("The file is too large!");
            return false;
        }
            // 图片尺寸检查
        if (!checkImageDimensions(file)) {
            response.setStatus(200);
            response.getWriter().write("Image dimensions are too large!");
            return false;
        }
        //获取文件类型
        String type = file.getContentType();
        // 文件重命名或生成唯一标识
        String newFileName = generateUniqueFileName(file.getOriginalFilename());

        // 添加水印
//        File watermarkedFile = addWatermark(file, newFileName);
        File targetFile = new File(newFileName);
        FileUtil.writeBytes(file.getBytes(), targetFile);
        ImgUtil.pressText(
                targetFile, // 原图片
                targetFile, // 生成的水印图片名称
                "LangXEchO", // 水印文字
                Color.ORANGE, // 水印文字颜色
                new Font("黑体", Font.BOLD, 20), // 字体
                0, // x坐标修正值
                0, // y坐标修正值
                0.8f // 透明度
        );
        // 记录上传日志
        logUpload(file, newFileName);

        // 将水印文件转换为 MultipartFile
        MultipartFile watermarkedMultipartFile = new MockMultipartFile(
                "file",                           // 表单字段名称
                newFileName,                      // 新文件名
                type,            // 原始文件类型
                new FileInputStream(targetFile)  // 水印后的文件输入流
        );

        // 将水印后的文件设置为新的请求参数
        multipartRequest.setAttribute("file",watermarkedMultipartFile);


        return true; // 继续请求处理
    }

    private boolean isAllowedFileType(String contentType) {
        for (String type : ALLOWED_TYPES) {
            if (type.equals(contentType)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    private boolean checkImageDimensions(MultipartFile file) throws IOException {
        BufferedImage image = ImageIO.read(file.getInputStream());
        return image != null && (image.getWidth() <= 1920 && image.getHeight() <= 1080); // 例如：最大宽高限制
    }

    private String generateUniqueFileName(String originalFilename) {
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        return PinyinUtil.getPinyin(originalFilename.replace(suffix, "")) + "_" + IdUtil.simpleUUID() + suffix;
    }

    private File addWatermark(MultipartFile file, String newFileName) {
        String url = null;
        // 创建一个临时文件
        File targetFile = new File(newFileName);

        try {
            // 将 MultipartFile 转换为 File
            FileUtil.writeBytes(file.getBytes(), targetFile);

            // 添加文字水印
            ImgUtil.pressText(
                    targetFile, // 原图片
                    targetFile, // 生成的水印图片名称
                    "LangXEchO", // 水印文字
                    Color.ORANGE, // 水印文字颜色
                    new Font("黑体", Font.BOLD, 20), // 字体
                    0, // x坐标修正值
                    0, // y坐标修正值
                    0.8f // 透明度
            );
            return targetFile;
            // 上传文件到 MinIO
//            String originalFilename = file.getOriginalFilename();
//            assert originalFilename != null;
//            String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));

            // 使用唯一文件名上传到 MinIO
//            try (InputStream inputStream = new FileInputStream(targetFile)) {
//                url = minIoTemplate.putObject("langxecho", "test/" + newFileName, inputStream);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 删除临时文件
            if (targetFile.exists()) {
                targetFile.delete();
            }
        }

        return targetFile; // 返回上传后的链接
    }


    private void logUpload(MultipartFile file, String newFileName) {
        // 创建日志对象，这里使用类名作为日志名称
        Log log = LogFactory.get();

        // 记录日志，记录文件上传的信息
        log.info("Uploaded file: {} at {}", newFileName, DateUtil.now());
    }
}
