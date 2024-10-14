package top.langxecho.springboot.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.langxecho.springboot.data.entity.Course;

import java.util.List;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/12 15:28
 */
@Mapper
public interface CourseMapper {
    List<Course> getCourse();
}
