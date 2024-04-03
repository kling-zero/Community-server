package com.zeroone.star.project.dto.community.transactions.parkingfee;

import com.zeroone.star.project.vo.community.transactions.buildfee.FeeConfigsVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.FeeTypeCdsVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.parkingfee.ParkingAreaVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SaveParkingFeeDTO {
    @ApiModelProperty(value = "小区ID", example ="2022090665021542")
    private String communityId;
    @ApiModelProperty(value = "车辆ID", example ="802022101260727052")
    private String carId;
    @ApiModelProperty(value = "车辆状态", example = "H")
    private List<String> carState;
    @ApiModelProperty(value = "出账类型")
    private String billType;
    @ApiModelProperty(value = "费用Id", example = "922022101175295767")
    private String configId;
    @ApiModelProperty(value = "费用类型", example = "")
    private List<FeeConfigsVO> feeConfigs;
    @ApiModelProperty(value = "费用标识 1003006 为周期性费用 2006012 为一次性费用", example = "1003006")
    private String feeFlag;
    @ApiModelProperty(value = "费用类型", example = "888800010015")
    private String feeTypeCd;
    @ApiModelProperty(value = "支付类别", example = "")
    private List<FeeTypeCdsVO> feeTypeCds;
    @ApiModelProperty(value = "", example = "false")
    private boolean isMore;
    @ApiModelProperty(value = "位置类型名称", example = "1栋1单元109室")
    private String locationTypeCdName;
    @ApiModelProperty(value = "位置类型，1000 大门 2000 单元门 3000 房屋门 4000 楼栋", example = "1000")
    private String locationTypeCd;
    @ApiModelProperty(value = "对象ID，大门时小区ID，单元门 时单元ID 房屋时房屋ID，楼栋时 楼栋ID", example = "752022100991611049")
    private String locationObjId;
    @ApiModelProperty(value = "")
    private String paId;
    @ApiModelProperty(value = "")
    private String psId;
    @ApiModelProperty(value = "开始时间", example = "2022-10-14 00:00:00")
    private Date startTime;
    @ApiModelProperty(value = "停车区域", example = "")
    private List<ParkingAreaVO> pakingArea;


}
