package top.langxecho.springboot.websocket.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/12 13:35
 */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class Clazz {
    private Integer clazzId;
    private String clazzName;
    private Integer teacherId;
    private Teacher teacher;
    // 在一方中声明多方的集合
    private List<Student> students;
}
