package com.zeroone.star.project.vo.community.roomRenovation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecordRenovationVO {
    @ApiModelProperty(value = "是否违规", example = "Y")
    private String isTrue;
    @ApiModelProperty(value = "违规文字说明", example = "违规")
    private String isTrueName;
    @ApiModelProperty(value = "装修记录ID", example = "172022100943551097")
    private String recordId;
    @ApiModelProperty(value = "房屋ID", example = "752022100987340783")
    private String roomId;
    @ApiModelProperty(value = "房屋名称", example = "21-01-501")
    private String roomName;
    @ApiModelProperty(value = "文件原名", example = "img/20221014/5a963f6f-d89d-44ce-8128-1199ce5a5e43.jpg")
    private String fileRealName;
    @ApiModelProperty(value = "文件真实保存地址", example = "img/20221014/5a963f6f-d89d-44ce-8128-1199ce5a5e43.jpg")
    private String fileSaveName;
    @ApiModelProperty(value = "文件保存地址", example = "https://java110.oss-cn-beijing.aliyuncs.com/hc/img/20221014/5a963f6f-d89d-44ce-8128-1199ce5a5e43.jpg")
    private String url;
    @ApiModelProperty(value = "装修ID", example = "172022100943551097")
    private String rId;
    @ApiModelProperty(value = "备注", example = "2022090665021542")
    private String remark;
    @ApiModelProperty(value = "验房人ID", example = "302022090667451419")
    private String staffId;
    @ApiModelProperty(value = "验房人", example = "wuxw")
    private String staffName;
    @ApiModelProperty(value = "状态", example = "4000")
    private String state;
    @ApiModelProperty(value = "数据状态", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "创建时间", example = "2022-09-15 09:05:37")
    private LocalDateTime createTime;
}
