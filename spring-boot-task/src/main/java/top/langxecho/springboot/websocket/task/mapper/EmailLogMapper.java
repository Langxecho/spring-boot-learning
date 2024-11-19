package top.langxecho.springboot.websocket.task.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.langxecho.springboot.websocket.task.entity.EmailLog;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/28 15:36
 */
@Mapper
public interface EmailLogMapper extends BaseMapper<EmailLog> {
}
