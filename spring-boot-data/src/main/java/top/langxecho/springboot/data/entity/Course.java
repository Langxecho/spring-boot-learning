package top.langxecho.springboot.data.entity;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/12 15:06
 */

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    private Integer courseId;
    private String courseName;
    private List<Student> students;
}