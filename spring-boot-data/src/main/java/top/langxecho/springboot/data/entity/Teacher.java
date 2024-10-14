package top.langxecho.springboot.data.entity;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/12 14:00
 */

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    private Integer teacherId;
    private String teacherName;
    private Integer clazzId;
    private Clazz clazz;
}