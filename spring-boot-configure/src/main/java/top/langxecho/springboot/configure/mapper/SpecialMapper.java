package top.langxecho.springboot.configure.mapper;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.langxecho.springboot.configure.entity.Special;

import java.util.List;

@Mapper
public interface SpecialMapper {

    @Select("SELECT * FROM special ORDER BY updated DESC")
    List<Special> findAll();
}

