package top.langxecho.springboot.websocket.task.job;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.langxecho.springboot.websocket.task.service.MailService;

import java.time.LocalDateTime;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/28 15:42
 */
@Component
@AllArgsConstructor
@Slf4j
public class DailyReportTask {
    private final MailService mailService;

    @Scheduled(cron = "0 48 15 * * ?")
    public void sendReport(){
        String report = "这是每日报表的内容";
        mailService.sendMail("1908630172@qq.com","每日数据报表",report);
        log.info("报表已生成并发送邮件完成！{}", LocalDateTime.now());
    }
}
