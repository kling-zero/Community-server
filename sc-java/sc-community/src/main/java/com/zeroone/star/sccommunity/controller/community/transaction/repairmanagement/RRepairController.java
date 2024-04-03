package com.zeroone.star.sccommunity.controller.community.transaction.repairmanagement;


import com.zeroone.star.project.community.transactions.repairmanagemment.RepairSettingApis;
import com.zeroone.star.project.community.transactions.repairmanagemment.RepairStaffApis;
import com.zeroone.star.project.dto.community.transactions.repairmanagement.OwnerRepairManageDTO;
import com.zeroone.star.project.query.community.transactions.repairmanagement.OwnerRepairManageQuery;
import com.zeroone.star.project.query.community.transactions.repairmanagement.RepairSettingQuery;
import com.zeroone.star.project.query.community.transactions.repairmanagement.RepairStaffQuery;
import com.zeroone.star.project.community.transactions.repairmanagemment.RepairManagementApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.repairmanagement.OwnerRepairManageVO;
import com.zeroone.star.project.vo.community.transactions.repairmanagement.RepairSettingVO;
import com.zeroone.star.project.vo.community.transactions.repairmanagement.RepairStaffVO;
import com.zeroone.star.sccommunity.entity.repairmanagement.RRepairPool;
import com.zeroone.star.sccommunity.service.repairmanagement.IRRepairPoolService;
import com.zeroone.star.sccommunity.service.repairmanagement.IRRepairSettingService;
import com.zeroone.star.sccommunity.service.repairmanagement.IRRepairUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Gerins
 * @since 2022-10-15
 */
@RestController
@RequestMapping("/sccommunity/r-repair-pool")
@Api(tags = "报修单")
@Validated
public class RRepairController implements RepairManagementApis, RepairStaffApis, RepairSettingApis {

    @Autowired
    IRRepairPoolService repairPoolService;

    @Autowired
    IRRepairUserService repairUserService;

    @Autowired
    IRRepairSettingService repairSettingService;

    @GetMapping("query-all")
    @ApiOperation(value = "查询所有报修单信息")
    @Override
    public JsonVO<PageVO<OwnerRepairManageVO>> queryAll(OwnerRepairManageQuery condition) {

        PageVO<OwnerRepairManageVO> ownerRepairManageVOPageVO = repairPoolService.listByCondition(condition);

        return JsonVO.success(ownerRepairManageVOPageVO);
    }


    @PostMapping("add-owner-epair")
    @ApiOperation(value = "新增一条报修单记录")
    @Override
    public JsonVO<String> addOwnerRepair(@RequestBody OwnerRepairManageDTO ownerRepairManageDTO) {

        RRepairPool rRepairPool = new RRepairPool();
        BeanUtils.copyProperties(ownerRepairManageDTO, rRepairPool);

        rRepairPool.setBId("-1");
        rRepairPool.setState("1000");
        rRepairPool.setStatusCd("0");
        rRepairPool.setRepairChannel("T");

        repairPoolService.save(rRepairPool);
        return JsonVO.success("成功");
    }

    @GetMapping("query-allRepairSetting")
    @ApiOperation(value = "查询所有报修设置信息")
    @Override
    public JsonVO<PageVO<RepairSettingVO>> queryAllRepairSetting(RepairSettingQuery condition) {
        PageVO<RepairSettingVO> repairSettingVOPageVO = repairSettingService.listAllRepairSetting(condition);
        return JsonVO.success(repairSettingVOPageVO);
    }


    @GetMapping("query-allRepairStaff")
    @ApiOperation(value = "查询报修单详细信息")
    @Override
    public JsonVO<PageVO<RepairStaffVO>> queryAll(RepairStaffQuery condition) {
        PageVO<RepairStaffVO> repairStaffVOPageVO = repairUserService.listAllRepairStaff(condition);
        return JsonVO.success(repairStaffVOPageVO);
    }
}

