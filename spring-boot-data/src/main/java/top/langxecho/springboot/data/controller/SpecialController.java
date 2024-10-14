package top.langxecho.springboot.data.controller;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/12 16:44
 */

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import top.langxecho.springboot.data.common.ResponseResult;
import top.langxecho.springboot.data.mapper.SpecialMapper;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/zhihu")
public class SpecialController {
    private final SpecialMapper specialMapper;

    @GetMapping("/specials")
    public ResponseResult getSpecials() {
        return ResponseResult.builder()
                .code(200)
                .msg("请求成功")
                .data(specialMapper.findAll())
                .build();
    }
}