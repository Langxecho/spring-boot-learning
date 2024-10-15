package top.langxecho.springboot.exception.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import top.langxecho.springboot.exception.annotation.Phone;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/15 14:06
 */
@Data
public class User {
    @NotBlank(message = "⽤户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    @Max(value = 100, message = "年龄不能超过100岁")
    @Min(value = 1, message = "年龄不能⼩于1岁")
    private int age;
    @Phone(message = "⼿机号格式不正确")
    private String phone;

}
