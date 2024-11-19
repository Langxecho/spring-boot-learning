package top.langxecho.springboot.websocket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import top.langxecho.springboot.websocket.entity.Course;
import top.langxecho.springboot.websocket.entity.StudentCourse;

import java.util.List;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/14 15:58
 */

public interface StudentCourseMapper extends BaseMapper<StudentCourse> {
    @Select("SELECT c.* FROM course c INNER JOIN student_course sc ON c.id = sc.course_id WHERE sc.student_id = #{studentId}")
    List<Course> selectCoursesByStudentId(Long studentId);
}