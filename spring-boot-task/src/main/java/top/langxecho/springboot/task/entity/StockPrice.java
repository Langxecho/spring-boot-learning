package top.langxecho.springboot.task.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/28 14:56
 */
@Data
@TableName("stock_price")
public class StockPrice {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Double price;
    private LocalDateTime updateTime;
}
