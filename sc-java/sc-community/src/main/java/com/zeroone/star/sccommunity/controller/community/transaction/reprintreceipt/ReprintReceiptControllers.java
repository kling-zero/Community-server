package com.zeroone.star.sccommunity.controller.community.transaction.reprintreceipt;

import com.zeroone.star.project.community.transactions.reprintreceipt.ReprintReceiptApis;
import com.zeroone.star.project.query.community.transactions.reprintreceipt.ReceiptQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.reprintreceipt.CarVO;
import com.zeroone.star.project.vo.community.transactions.reprintreceipt.ContractVO;
import com.zeroone.star.project.vo.community.transactions.reprintreceipt.FeeTypeVO;
import com.zeroone.star.project.vo.community.transactions.reprintreceipt.ReprintReceiptVO;
import com.zeroone.star.sccommunity.service.carinfo.IOwnerCarService;
import com.zeroone.star.sccommunity.service.reprintreceipt.IPayFeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tomcat
 * @Date 2022/10/16 0:10
 */
@RestController
@RequestMapping("")
@Api(tags = "补打收据")
@Validated
public class ReprintReceiptControllers implements ReprintReceiptApis {

    @Autowired
    private IPayFeeService payFeeService;
    @Autowired
    private IOwnerCarService ownerCarService;

    @GetMapping("/reprintReceipt")
    @ApiOperation(value = "分页查询补打收据")
    public JsonVO<PageVO<ReprintReceiptVO>> queryAll(ReceiptQuery receiptQuery){
        PageVO<ReprintReceiptVO> pageVO = payFeeService.getAll(receiptQuery);
        return JsonVO.success(pageVO);
    }

    @GetMapping("/queryFeeType")
    @ApiOperation(value = "查询收费类型")
    @Override
    public JsonVO<List<FeeTypeVO>> queryFeeType() {
        List<FeeTypeVO> types = payFeeService.getTypes();
        return JsonVO.success(types);
    }

    @GetMapping("/queryCar")
    @ApiOperation(value = "查询所有车辆")
    @Override
    public JsonVO<List<CarVO>> queryAllCar(String memberId) {
        List<CarVO> cars = ownerCarService.getAllCar(memberId);
        return JsonVO.success(cars);
    }

    @GetMapping("/queryContract")
    @ApiOperation(value = "查询所有合同")
    @Override
    public JsonVO<List<ContractVO>> queryAllContract(String memberId) {
        //没找到表的对应关系,先弄成查不到
        return JsonVO.success(null);
    }
}
