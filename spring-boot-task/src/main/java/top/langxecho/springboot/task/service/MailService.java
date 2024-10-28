package top.langxecho.springboot.task.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import top.langxecho.springboot.task.entity.EmailLog;
import top.langxecho.springboot.task.mapper.EmailLogMapper;

import java.time.LocalDateTime;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/28 15:37
 */
@Service
@AllArgsConstructor
@Slf4j
public class MailService {
    private  final JavaMailSender mailSender;
    private final EmailLogMapper emailLogMapper;

    public void sendMail(String to,String subject,String content){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("1908630172@qq.com");
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailSender.send(mailMessage);

        EmailLog emailLog = new EmailLog();

        emailLog.setRecipient(to);

        emailLog.setSubject(subject);

        emailLog.setContent(content);

        emailLog.setSentAt(LocalDateTime.now());

        emailLogMapper.insert(emailLog);

// 控制台输出日志
        log.info("邮件已发送至:{}", to);

    }
}
