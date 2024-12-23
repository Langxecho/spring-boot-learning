package top.langxecho.springboot.websocket.task.timer;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/28 14:23
 */
@Slf4j
public class StockPriceTimer {
    public static void main(String[] args){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            double price = 100.0;
            final Random random = new Random();
            @Override
            public void run() {
                price += (random.nextDouble() -0.8) * 2;
                log.info("当前的股票价格是{}",price);

            }
        };
        timer.schedule(task,0,1000);
    }
}
