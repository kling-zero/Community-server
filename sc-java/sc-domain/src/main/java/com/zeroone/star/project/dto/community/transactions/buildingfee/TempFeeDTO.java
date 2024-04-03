package com.zeroone.star.project.dto.community.transactions.buildingfee;


import com.zeroone.star.project.vo.community.transactions.buildfee.FeeConfigsVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.FeeTypeCdsVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@ApiModel("临时收费传输数据对象")
public class TempFeeDTO {
    @ApiModelProperty(value = "金额", example = "1000")
    private BigDecimal amount;
    @ApiModelProperty(value = "小区ID", example = "2022081539020475")
    private String communityId;
    @ApiModelProperty(value = "费用类型", example = "888800010015")
    private String feeTypeCd;
    @ApiModelProperty(value = "费用项名称", example = "物业缴费测试xx")
    private String feeName;
    @ApiModelProperty(value = "对象名称", example = "1栋1单元101室")
    private String objName;
    @ApiModelProperty(value = "对象ID", example = "752022100991611049")
    private String objId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束时间", example = "2022-10-29 00:00:00")
    private LocalDateTime endTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始时间", example = "2022-10-15 00:00:00")
    private LocalDateTime startTime;
    @ApiModelProperty(value = "费用项标识", example = "S")
    private String feeNameFlag;

    @ApiModelProperty(value = "收费项目显示对象")
    private List<FeeConfigsVO> feeConfigs;
    @ApiModelProperty(value = "费用类别展示对象")
    private List<FeeTypeCdsVO> feeTypeCds;
}
