package top.langxecho.springboot.configure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import top.langxecho.springboot.configure.service.QrCodeService;

@RestController
@AllArgsConstructor
public class QrCodeController {

    private final QrCodeService qrCodeService;

    @GetMapping("/qrcode")
    public void qrcode() {
        qrCodeService.generateQrCode();
    }
}

