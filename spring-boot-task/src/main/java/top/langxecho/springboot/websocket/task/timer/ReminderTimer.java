package top.langxecho.springboot.websocket.task.timer;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/28 14:11
 */
@Slf4j
public class ReminderTimer {
    public static void main(String[] args){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int countdown = 10;
            @Override
            public void run() {

                if (countdown > 0){
                    countdown--;
                    log.info("倒计时：{}秒",countdown);
                }else {
                    log.info("倒计时结束");
                    timer.cancel();
                }
            }
        };
        timer.schedule(task,0,1000);
    }
}
