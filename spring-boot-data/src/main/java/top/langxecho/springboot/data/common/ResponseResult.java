package top.langxecho.springboot.data.common;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/12 16:39
 */

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseResult {
    private Integer code;
    private String msg;
    private Object data;
}