package top.langxecho.springboot.websocket.data.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.langxecho.springboot.websocket.data.entity.Course;
import top.langxecho.springboot.websocket.data.entity.Student;

import java.util.List;

@SpringBootTest
@Slf4j
class CourseMapperTest {
    @Resource
    private CourseMapper courseMapper;
    @Test
    void getCourse() {
        List<Course> courses = courseMapper.getCourse();
        courses.forEach(course -> {
            log.info("{}", course.getCourseName());
            List<Student> students = course.getStudents();
            students.forEach(student -> log.info("{},{}", student.getStudentName(), student.getHometown()));
        });
    }
}