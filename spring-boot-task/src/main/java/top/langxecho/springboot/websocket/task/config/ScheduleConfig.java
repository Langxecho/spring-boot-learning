package top.langxecho.springboot.websocket.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/28 14:45
 */
@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(sheduledTaskExecutor());
    }
    @Bean
    public Executor sheduledTaskExecutor() {
        //指定线程大小为3
        return Executors.newScheduledThreadPool(3);
    }
}
