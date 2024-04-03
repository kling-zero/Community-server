package com.zeroone.star.sccommunity.controller.community.transaction.buildingfee;

import com.zeroone.star.project.query.community.transactions.buildingfee.feedetails.FeeDetailsQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.feedetails.ListRoomQuery;
import com.zeroone.star.project.query.community.transactions.buildingfee.payfee.OwnerAccountQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.project.vo.community.transactions.buildfee.FeesVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.feedetails.FeeDetailsVO;
import com.zeroone.star.project.vo.community.transactions.buildfee.feedetails.RoomVO;
import com.zeroone.star.sccommunity.service.buildingfee.IFeeHistoryService;
import com.zeroone.star.sccommunity.service.buildingfee.IFeeService;
import com.zeroone.star.sccommunity.service.buildingfee.IRoomDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/transactions/building-fee/feeDetails")
@RequestMapping("/transactions/building-fee/feeDetails")
@Api(tags = "缴费历史接口")
@Validated
public class FeeDetailsController {
    @Autowired
    IFeeHistoryService feeDetailsService;
    @Autowired
    IRoomDetailsService roomDetailsService;
    @Autowired
    IFeeService feeService;

    @GetMapping("/getFee")
    @ApiOperation(value = "查询费用信息")
    public JsonVO<FeesVO> getFee(OwnerAccountQuery condition){
        FeesVO feesVO = feeService.selectOne(condition);
        return JsonVO.create(feesVO,ResultStatus.SUCCESS);
    }

    @GetMapping("/queryRoomByRoomId")
    @ApiOperation(value = "查询房间信息")
//    public JsonVO<List<RoomVO>>这里返回的应该是pageVO
    public JsonVO<PageVO<RoomVO>> queryRoomByRoomId(ListRoomQuery condition){
        PageVO<RoomVO> roomVOPageVO = roomDetailsService.listAll(condition);
        return JsonVO.create(roomVOPageVO,ResultStatus.SUCCESS);
    }

    @GetMapping("/queryFeeDetails")
    @ApiOperation(value = "查询缴费历史")
//    public JsonVO<List<FeeDetailsVO>> 这里返回的应该是pageVO
    public JsonVO<PageVO<FeeDetailsVO>> queryFeeDetails(FeeDetailsQuery condition){
        PageVO<FeeDetailsVO> feeDetailsVOPageVO = feeDetailsService.listFeeDetailHistory(condition);
        return JsonVO.create(feeDetailsVOPageVO,ResultStatus.SUCCESS);
    }
}
