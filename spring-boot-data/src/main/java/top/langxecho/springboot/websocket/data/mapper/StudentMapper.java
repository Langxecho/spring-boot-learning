package top.langxecho.springboot.websocket.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import top.langxecho.springboot.websocket.data.entity.Student;

import java.util.List;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/8 16:27
 */
@Mapper
public interface StudentMapper {
    int insert(Student student);
    Student findStudentById(int studentId);
    int updateById(Student student);
    int deleteById(int studentId);
    int batchInsert(@Param("students") List<Student> students);
    int batchDelete(@Param("idList") List<Integer> ids);
    int batchUpdate(@Param("students") List<Student> students);
    List<Student> selectByDynamicSql(Student student);

    Student getStudentManyToOne(int studentId);

    Student getStudent(int studentId);
}