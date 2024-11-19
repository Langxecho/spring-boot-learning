package top.langxecho.springboot.websocket.task.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.langxecho.springboot.websocket.task.job.ExportJob;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/28 16:02
 */
@Configuration
public class ExportQuartzConfig {
    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(ExportJob.class)
                .withIdentity("exportQuartzTask")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger(){
        // corn表达式
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail())
                .withIdentity("exportQuartzTask")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
