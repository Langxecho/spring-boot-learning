package top.langxecho.springboot.websocket.configure.mapper;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.langxecho.springboot.websocket.configure.entity.Special;

import java.util.List;

@Mapper
public interface SpecialMapper {

    @Select("SELECT * FROM special ORDER BY updated DESC")
    List<Special> findAll();
}

