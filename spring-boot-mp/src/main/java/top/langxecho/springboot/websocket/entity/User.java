package top.langxecho.springboot.websocket.entity;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/14 14:17
 */

import lombok.Data;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.time.LocalDateTime;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;

    // 自动填充创建时间
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    // 自动填充更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    // 逻辑删除字段
    @TableLogic
    private Integer deleted;
}