package top.langxecho.springboot.websocket.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.langxecho.springboot.websocket.data.entity.Special;

import java.util.List;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/12 16:35
 */
@Mapper

public interface SpecialMapper {
    List<Special> findAll();
}
