package top.langxecho.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.langxecho.springboot.entity.Clazz;
import top.langxecho.springboot.service.ClazzService;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/14 16:14
 */

@RestController
@RequestMapping("/clazz")
@AllArgsConstructor
public class ClazzController {
    private final ClazzService clazzService;
    /**
     * 获取班级和对应⽼师信息
     */
    @GetMapping("/{id}")
    public Clazz getClazzWithTeacher(@PathVariable Long id) {
        return clazzService.getClazzWithTeacher(id);
    }
}