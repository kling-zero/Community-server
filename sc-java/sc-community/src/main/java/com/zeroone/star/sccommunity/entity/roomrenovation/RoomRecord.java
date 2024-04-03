package com.zeroone.star.sccommunity.entity.roomrenovation;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@TableName("room_renovation_record")
public class RoomRecord {
    @ApiModelProperty(value = "装修记录id", example = "172021062911880008")
    private String recordId;
    @ApiModelProperty(value = "装修ID", example = "172021060394950172")
    private String rId;
    @ApiModelProperty(value = "员工姓名", example = "qqqq")
    private String staffName;
    @ApiModelProperty(value = "员工ID", example = "30518940136629616640")
    private String staffId;
    @ApiModelProperty(value = "数据状态", example = "0")
    private String statusCd;
    @ApiModelProperty(value = "状态", example = "5000")
    private String state;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", example = "2021-06-29 15:39:36")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "备注", example = "CS")
    private String remark;
    @ApiModelProperty(value = "是否违规", example = "true")
    private String isTrue;
}
