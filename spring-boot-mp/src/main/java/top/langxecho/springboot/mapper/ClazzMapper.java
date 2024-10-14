package top.langxecho.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import top.langxecho.springboot.entity.Clazz;
import top.langxecho.springboot.entity.Teacher;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/14 15:56
 */

public interface ClazzMapper extends BaseMapper<Clazz> {
    @Select("SELECT * FROM teacher WHERE id = #{teacherId}")
    Teacher selectTeacherByClazzId(Long teacherId);
}