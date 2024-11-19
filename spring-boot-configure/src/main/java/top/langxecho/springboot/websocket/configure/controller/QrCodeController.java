package top.langxecho.springboot.websocket.configure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import top.langxecho.springboot.websocket.configure.service.QrCodeService;

@RestController
@AllArgsConstructor
public class QrCodeController {

    private final QrCodeService qrCodeService;

    @GetMapping("/qrcode")
    public void qrcode() {
        qrCodeService.generateQrCode();
    }
}

