package top.langxecho.springboot.task.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.langxecho.springboot.task.job.SimpleQuartzTask;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/28 16:02
 */
@Configuration
public class SimpleQuartzConfig {
//    @Bean
//    public JobDetail jobDetail(){
//        return JobBuilder.newJob(SimpleQuartzTask.class)
//                .withIdentity("simpleQuartzTask")
//                .storeDurably()
//                .build();
//    }

//    @Bean
//    public Trigger trigger(){
//        // corn表达式
//        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
//        return TriggerBuilder.newTrigger()
//                .forJob(jobDetail())
//                .withIdentity("simpleQuartzTask")
//                .withSchedule(scheduleBuilder)
//                .build();
//    }
}
