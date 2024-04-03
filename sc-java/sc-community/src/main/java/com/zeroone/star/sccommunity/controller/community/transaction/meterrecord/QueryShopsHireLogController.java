package com.zeroone.star.sccommunity.controller.community.transaction.meterrecord;

import com.zeroone.star.project.query.sample.communitymanage.busaccept.meterrecords.QueryShopsHireLogQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.project.vo.community.transactions.meterrecords.QueryShopsHireLogVO;
import com.zeroone.star.sccommunity.service.meterrecord.IQueryShopsHireLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tomcat ,业务实现：业峰
 * @Date 2022/10/16 10:38
 */
@RestController
@RequestMapping("ShopsHireLog")
@Api(tags = "历史业主")//该房间的历史业主,通过小区id和房间号查询
@Validated
public class QueryShopsHireLogController {
    @Autowired
    IQueryShopsHireLogService queryShopsHireLogService;

    @GetMapping("/queryShopsHireLog")
    @ApiOperation(value = "分页查询抄表记录")
    JsonVO<PageVO<QueryShopsHireLogVO>> queryAll(QueryShopsHireLogQuery recordsQuery){
        PageVO<QueryShopsHireLogVO> queryShopsHireLogVOPageVO = queryShopsHireLogService.selectByCommunityIdRoomNum(recordsQuery);
        return JsonVO.create(queryShopsHireLogVOPageVO, ResultStatus.SUCCESS);
    }
}
