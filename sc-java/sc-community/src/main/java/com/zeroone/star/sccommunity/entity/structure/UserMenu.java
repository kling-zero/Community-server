package com.zeroone.star.sccommunity.entity.structure;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author 业峰
 * @Date 2022/10/21
 */
@Data
@TableName("m_menu_user")
public class UserMenu {
    private String icon;
    private String muId;
    private String name;
    private Integer seq;
    private String staffId;
    private String statusCd;
    private String url;
}
