package top.langxecho.zhihu.api.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.langxecho.zhihu.api.entity.Special;
import top.langxecho.zhihu.api.mapper.SpecailMapper;
import top.langxecho.zhihu.api.service.SpecailService;
import top.langxecho.zhihu.api.vo.PagesVO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/14 15:26
 */
@Service
public class SpecailServiceImpl implements SpecailService {
    @Resource
    public SpecailMapper specailMapper;

    @Override
    public List<Special> getAll() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Special> specials = specailMapper.selectList(null);
        specials.forEach(special -> {
            String format = df.format(new Date(Long.parseLong(special.getUpdated() + "000")));
            special.setUpdated(format);
        });
        return specials;
    }

    @Override
    public PagesVO getAllByPages(int current, int mesNum) {
        Page<Special> page = new Page<>(current,mesNum);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Special> specials = specailMapper.selectList(page,null);
        specials.forEach(special -> {
            String format = df.format(new Date(Long.parseLong(special.getUpdated() + "000")));
            special.setUpdated(format);
        });

        PagesVO pages = new PagesVO(page.getCurrent(),page.getSize(),page.getPages(),specials);
        return pages;
    }
}
