package top.langxecho.springboot.websocket.configure.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.langxecho.springboot.websocket.configure.entity.Mail;
import top.langxecho.springboot.websocket.configure.service.EmailService;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/23 21:19
 */

@RestController
@AllArgsConstructor
public class EmailController {
    private final EmailService emailService;
    @PostMapping("/mail")
    public void sendEmail(@RequestBody Mail mail) {
        emailService.sendSimpleEmail(mail.getTo(), mail.getSubject(), mail
                .getBody());
    }
}
