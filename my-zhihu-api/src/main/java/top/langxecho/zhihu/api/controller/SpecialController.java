package top.langxecho.zhihu.api.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.langxecho.zhihu.api.common.RestBean;
import top.langxecho.zhihu.api.entity.Special;
import top.langxecho.zhihu.api.service.SpecailService;
import top.langxecho.zhihu.api.vo.PagesVO;

import java.util.List;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/14 15:47
 */
@RestController
@RequestMapping("/api/v1/special")
public class SpecialController {
    @Resource
    private SpecailService specailService;

    @GetMapping("/all")
    public RestBean<List<Special>> getAllMes(){
        List<Special> all = specailService.getAll();
        return RestBean.success(all);
    }
    @GetMapping("/allByPage")
    public RestBean<PagesVO> getAllMes(@RequestParam int current,@RequestParam int mesNum){
        PagesVO pagevo = specailService.getAllByPages(current,mesNum);
        return RestBean.success(pagevo);
    }

}
