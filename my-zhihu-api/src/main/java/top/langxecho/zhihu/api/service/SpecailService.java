package top.langxecho.zhihu.api.service;

import org.springframework.stereotype.Service;
import top.langxecho.zhihu.api.entity.Special;
import top.langxecho.zhihu.api.vo.PagesVO;

import java.util.List;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/14 15:25
 */
@Service
public interface SpecailService {
    public List<Special> getAll();
    public PagesVO getAllByPages(int current, int mesNum);
}
