package top.langxecho.springboot.websocket.task.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.langxecho.springboot.websocket.task.entity.StockPrice;

@Mapper
public interface StockPriceMapper extends BaseMapper<StockPrice> {
}
