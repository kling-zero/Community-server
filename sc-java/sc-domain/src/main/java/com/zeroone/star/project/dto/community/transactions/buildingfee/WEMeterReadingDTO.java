package com.zeroone.star.project.dto.community.transactions.buildingfee;

import com.zeroone.star.project.vo.community.transactions.buildfee.FeeConfigsVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.MeterTypesVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel("水电抄表传输数据对象")
public class WEMeterReadingDTO {
        @ApiModelProperty(value = "小区ID", example = "2022090665021542")
        private String communityId;
        @ApiModelProperty(value = "本期度数", example = "0.00")
        private String curDegrees;
        @ApiModelProperty(value = "本期读表时间", example = "2022-10-15 03:00:50")
        private Date curReadingTime;
        @ApiModelProperty(value = "上期度数", example = "0.00")
        private String preDegrees;
        @ApiModelProperty(value = "上期读表时间", example = "2022-10-15 13:39:49")
        private Date preReadingTime;
        @ApiModelProperty(value = "对象名称", example = "1栋1单元1室")
        private String objName;
        @ApiModelProperty(value = "价格", example = "0")
        private int price;
        @ApiModelProperty(value = "水费ID", example = "102022101556357858")
        private String waterId;
        @ApiModelProperty(value = "对象ID", example = "752022101002411137")
        private String objId;
        @ApiModelProperty(value = "对象类型", example = "3333")
        private String objType;
        @ApiModelProperty(value = "抄表类型", example = "102022090813867155")
        private String meterType;
        @ApiModelProperty(value = "备注", example = "无")
        private String remark;
        @ApiModelProperty(value = "房屋Id", example = "752022101002411137")
        private String roomId;
        @ApiModelProperty(value = "费用类型，物业费、停车费", example = "888800010016")
        private String feeTypeCd;
        @ApiModelProperty(value = "费用ID", example = "922022092269180222")
        private String configId;
        @ApiModelProperty(value = "有无房间", example = "true")
        private boolean hasRoom;
        @ApiModelProperty(value = "业主名称", example = "张三")
        private String ownerName;
        @ApiModelProperty(value = "计算公式 1001 面积*单价+附加费 2002 固定费用", example = "1001")
        private String computingFormula;

        @ApiModelProperty(value = "收费项目显示对象")
        private List<FeeConfigsVO> feeConfigs;
        @ApiModelProperty(value = "抄表类型显示对象")
        private List<MeterTypesVO> meterTypes;
}
