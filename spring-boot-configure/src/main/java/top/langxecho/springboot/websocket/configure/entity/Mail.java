package top.langxecho.springboot.websocket.configure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/23 21:18
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mail {
    private String to;
    private String subject;
    private String body;
}
