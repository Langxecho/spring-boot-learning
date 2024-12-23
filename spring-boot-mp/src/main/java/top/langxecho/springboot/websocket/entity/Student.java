package top.langxecho.springboot.websocket.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/14 15:54
 */

@Data
public class Student {
    private Long id;
    private String name;
    private Long clazzId;
    // ⽤于⼀对多映射
    @TableField(exist = false)
    private List<Course> courses;
}