package top.langxecho.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/14 15:39
 */
@Data
public class Clazz {
    private Long id;
    private String name;
    private Long teacherId;
    // ⽤于⼀对⼀映射
    @TableField(exist = false)
    private Teacher teacher;
}
