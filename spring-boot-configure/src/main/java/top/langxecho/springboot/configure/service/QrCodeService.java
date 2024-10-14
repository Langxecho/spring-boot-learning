package top.langxecho.springboot.configure.service;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/23 20:44
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

import cn.hutool.extra.qrcode.QrCodeUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Service
@Slf4j
public class QrCodeService {

    @Value("${custom.qrcode.content}")
    private String qrContent;

    public void generateQrCode() {
        QrCodeUtil.generate(qrContent, 300, 300, new File("qrcode.png"));
        log.info("二维码生成成功！");
    }
}


