package top.langxecho.zhihu.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.langxecho.zhihu.api.entity.Special;

import java.util.List;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/14 16:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagesVO {
    Long current;
    Long mesNum;//每页记录数
    Long total;
    List<Special> data;
}
