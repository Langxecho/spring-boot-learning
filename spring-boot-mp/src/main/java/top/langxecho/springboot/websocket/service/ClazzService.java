package top.langxecho.springboot.websocket.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.langxecho.springboot.websocket.entity.Clazz;
import top.langxecho.springboot.websocket.entity.Teacher;
import top.langxecho.springboot.websocket.mapper.ClazzMapper;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/14 15:59
 */

@Service
@AllArgsConstructor
public class ClazzService {
    private final ClazzMapper clazzMapper;
    /**
     * 根据班级ID获取班级和对应⽼师
     */
    public Clazz getClazzWithTeacher(Long clazzId) {
        Clazz clazz = clazzMapper.selectById(clazzId);
        if (clazz != null) {
            Teacher teacher = clazzMapper.selectTeacherByClazzId(clazz.getTeacherId());
            clazz.setTeacher(teacher);
        }
        return clazz;
    }
}