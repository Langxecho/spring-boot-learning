package top.langxecho.springboot.websocket.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.langxecho.springboot.websocket.entity.Course;
import top.langxecho.springboot.websocket.entity.Student;
import top.langxecho.springboot.websocket.mapper.StudentCourseMapper;
import top.langxecho.springboot.websocket.mapper.StudentMapper;

import java.util.List;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/14 16:01
 */

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentMapper studentMapper;
    private final StudentCourseMapper studentCourseMapper;
    /**
     * 根据学⽣ID获取该学⽣的课程信息
     */
    public Student getStudentWithCourses(Long studentId) {
        Student student = studentMapper.selectById(studentId);
        if (student != null) {
            List<Course> courses = studentCourseMapper.selectCoursesByStudentId(studentId);
            student.setCourses(courses);
        }
        return student;
    }
}