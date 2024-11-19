package top.langxecho.springboot.websocket.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.langxecho.springboot.websocket.data.entity.Teacher;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/12 14:06
 */

@Mapper
public interface TeacherMapper {
    /**
     * 根据id查询教师信息（同时通过一对一查询出其管理的班级信息）
     *
     * @param teacherId 教师id
     * @return 教师信息
     */
    Teacher findTeacherById(int teacherId);
}