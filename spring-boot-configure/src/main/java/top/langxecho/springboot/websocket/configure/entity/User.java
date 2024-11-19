package top.langxecho.springboot.websocket.configure.entity;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/23 14:48
 */
@Data
public class User {
    @NotNull
    @Size(min = 3, max = 20)
    private String username;
    @NotNull
    private String password;
    @Email
    private String email;
    @Min(18)
    @Max(100)
    private int age;
    @Pattern(regexp = "^[0-9]{11}$")
    private String phoneNumber;
    @Future
    private LocalDate subscriptionEndDate;
    @Positive
    private int score;
    @URL
    private String website;
}