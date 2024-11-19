package top.langxecho.springboot.websocket.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.langxecho.springboot.websocket.entity.Student;
import top.langxecho.springboot.websocket.service.StudentService;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/14 16:15
 */

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
    /**
     * 获取学⽣及其课程信息
     */
    @GetMapping("/{id}/courses")
    public Student getStudentWithCourses(@PathVariable Long id) {
        return studentService.getStudentWithCourses(id);
    }
}