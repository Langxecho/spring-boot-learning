package top.langxecho.springboot.data.entity;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/12 16:33
 */

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Special {
    private String id;
    private String title;
    private String introduction;
    private String banner;
    private Integer viewCount;
    private Integer followersCount;
    private Boolean isFollowing;
    private Long updated;
    private List<Section> sections;
}
