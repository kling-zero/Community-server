package com.zeroone.star.sccommunity.entity.prrmanagement;

import com.alibaba.nacos.shaded.org.checkerframework.checker.formatter.qual.FormatMethod;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@TableName("property_right_registration_detail")
public class PRRDetail {
    private String prrdId;
    private String prrId;
    private String securities;
    private String isTrue;

    private LocalDateTime createTime;
    private String createUser;
    private String statusCd;
}
