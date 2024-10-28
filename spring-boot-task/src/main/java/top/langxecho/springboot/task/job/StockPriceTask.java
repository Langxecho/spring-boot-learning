package top.langxecho.springboot.task.job;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.langxecho.springboot.task.entity.StockPrice;
import top.langxecho.springboot.task.mapper.StockPriceMapper;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/28 14:59
 */
@Component
@AllArgsConstructor
@Slf4j
public class StockPriceTask {
    final StockPriceMapper mapper;
    private final Random random = new Random();


//    @Scheduled(fixedRate = 4000)
//    public void updateStockPrice(){
//        double price = 100 + random.nextDouble() * 50;
//        double roundedValue = Math.round(price * 100.0) / 100.0;
//        StockPrice stockPrice = new StockPrice();
//        stockPrice.setPrice(roundedValue);
//        stockPrice.setName("小米");
//        stockPrice.setUpdateTime(LocalDateTime.now());
//
//        mapper.insert(stockPrice);
//        log.info("数据插入成功：{}",stockPrice.getPrice());
//    }



}
