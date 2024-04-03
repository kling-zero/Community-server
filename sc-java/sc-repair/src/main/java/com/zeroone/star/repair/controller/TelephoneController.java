package com.zeroone.star.repair.controller;

import com.zeroone.star.project.dto.repair.TelephoneDTO;
import com.zeroone.star.project.dto.repair.TelephoneModifyDTO;
import com.zeroone.star.project.query.repair.TelephoneQuery;
import com.zeroone.star.project.repair.TelephoneApis;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.ResultStatus;
import com.zeroone.star.project.vo.repair.TelephoneVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName TelephoneController
 * @Description TODO
 * @Author Colin
 * @Date 2022/10/18 15:08
 * @Version 1.0
 */
@RestController
@RequestMapping("repair")
@Api(tags = "repair")
@Validated
public class TelephoneController implements TelephoneApis {


    @GetMapping("/telephone/list")
    @ApiOperation(value = "分页查询所有符合条件的电话报修记录")
    @Override
    public JsonVO<PageVO<TelephoneVO>> quaryAll(TelephoneQuery condition) {
        return null;
    }

    @PostMapping("/telephone/save")
    @ApiOperation(value = "新增电话报修记录")
    @Override
    public JsonVO<ResultStatus> save(TelephoneDTO record) {
        return null;
    }

    @PutMapping("/telephone/update")
    @ApiOperation(value = "修改电话报修记录")
    @Override
    public JsonVO<ResultStatus> update(TelephoneModifyDTO record) {
        return null;
    }

    @DeleteMapping("/telephone/remove")
    @ApiOperation(value = "删除电话报修记录")
    @Override
    public JsonVO<ResultStatus> remove(int repairID) {
        return null;
    }




}
