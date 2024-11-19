package top.langxecho.springboot.websocket.task.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/28 15:35
 */
@Data
@TableName("email_log")
public class EmailLog {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String recipient;

    private String subject;

    private String content;

    private LocalDateTime sentAt;
}
