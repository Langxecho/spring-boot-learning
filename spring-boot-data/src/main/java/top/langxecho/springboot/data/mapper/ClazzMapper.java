package top.langxecho.springboot.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.langxecho.springboot.data.entity.Clazz;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/12 14:09
 */
@Mapper
public interface ClazzMapper {
    Clazz getClazzById(int clazzId);
    Clazz getClazz(int clazzId);

}