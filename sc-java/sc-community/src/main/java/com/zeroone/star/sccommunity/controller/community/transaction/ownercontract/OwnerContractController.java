package com.zeroone.star.sccommunity.controller.community.transaction.ownercontract;

import com.zeroone.star.project.dto.community.transactions.ownerContract.OwnerContractByObjDTO;
import com.zeroone.star.project.dto.community.transactions.ownerContract.OwnerContractDTO;
import com.zeroone.star.project.dto.community.transactions.ownerContract.PrintContractDTO;
import com.zeroone.star.project.dto.community.transactions.ownerContract.UpdateContractDTO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.ownerContract.*;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions/Owner-contract")
@Api(tags = "业主合同")
@Validated
public class OwnerContractController {
    @GetMapping("/queryContractByObj")
    @ApiOperation(value = "通过合同对象查询合同")
    JsonVO<PageVO<OwnerContractVO>> queryContractByObj(OwnerContractByObjDTO contation) {
        return null;
    }


    @GetMapping("/queryContract")
    @ApiOperation(value = "合同查询接口")
    JsonVO<PageVO<OwnerContractVO>> queryContract(OwnerContractDTO contation) {
        return null;
    }

    @GetMapping("/queryContractDetail")
    @ApiOperation(value = "查询合同细节")
    JsonVO<PageVO<OwnerContractVO>> queryContractList(OwnerContractDTO contation) {
        return null;
    }

    @GetMapping("/queryContractFile")
    @ApiOperation(value = "查询合同文件")
    JsonVO<PageVO<OwnerContractVO>> queryContractFile(OwnerContractDTO contation) {
        return null;
    }


    @PostMapping("/updateContract")
    @ApiOperation(value = "合同更新接口")
    JsonVO<String> updateContract(UpdateContractDTO contation) {
        return null;
    }

    @PostMapping("/deleteContract")
    @ApiOperation(value = "合同删除接口")
    JsonVO<String> deleteContract(UpdateContractDTO contation) {
        return null;
    }

    @GetMapping("/queryContractType")
    @ApiOperation(value = "查询合同类型")
    JsonVO<PageVO<ContraTypeVO>> queryContractType(PageVO contation) {
        return null;
    }

    @GetMapping("/queryContractPartya")
    @ApiOperation(value = "查询甲方合同")
    JsonVO<PageVO<ContractPartyaVO>> queryContractPartya(PageVO contation) {
        return null;
    }

    @PostMapping("/saveContract")
    @ApiOperation(value = "添加合同接口")
    JsonVO<String> saveContract(UpdateContractDTO contation) {
        return null;
    }

    @GetMapping("/printContractPartya")
    @ApiOperation(value = "打印合同")
    JsonVO<PageVO<PrintContractVO>> printContract(PrintContractDTO contation){
        return null;
    };
    @GetMapping("/queryContractRoom")
    @ApiOperation(value = "查询房屋合同")
    JsonVO<PageVO<QueryContractDetailVO>> queryContractRoom(OwnerContractDTO contation){
        return null;
    };

}
