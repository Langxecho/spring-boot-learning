package top.langxecho.zhihu.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/14 15:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Special {
    private String id;
    private String title;
    private String banner;
    private String introduction;
    private String isFollowing;
    private Integer viewCount;
    private String updated;
}
