package top.langxecho.springboot.websocket.data.entity;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/12 16:33
 */

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Section {
    private String sectionId;
    private String specialId;
    private String sectionTitle;
}