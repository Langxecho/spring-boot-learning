package top.langxecho.springboot.websocket.task.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/28 16:00
 */
@Slf4j
public class SimpleQuartzTask extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("simpleQuartzTask,执行时间,:{}", LocalDateTime.now());
    }
}
