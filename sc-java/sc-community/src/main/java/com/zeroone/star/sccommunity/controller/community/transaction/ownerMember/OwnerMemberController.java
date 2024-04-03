package com.zeroone.star.sccommunity.controller.community.transaction.ownerMember;

import com.zeroone.star.project.community.transactions.listOwnerMember.OwnerMemberApis;
import com.zeroone.star.project.dto.community.transactions.ownerMember.DeleteOwnerMemberDto;
import com.zeroone.star.project.dto.community.transactions.ownerMember.SaveOwnerMemberDto;
import com.zeroone.star.project.dto.community.transactions.ownerMember.UpdateOwnerMemberDto;
import com.zeroone.star.project.query.community.transactions.ownerMember.OwnerMemberQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.ownermember.OwnerMemberVO;
import com.zeroone.star.sccommunity.service.ownermember.IBuildingOwnerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;

@RestController
@RequestMapping("/transactions/Owner-member")
@Api(tags = "业主家庭成员")
@Validated
public class OwnerMemberController implements OwnerMemberApis {
    @Resource
    IBuildingOwnerService iBuildingOwnerService;

    @GetMapping("/query-Owners-members")
    @ApiOperation(value = "分页查询业主家庭成员")
    @Override
    public JsonVO<PageVO<OwnerMemberVO>> queryAll(@Validated OwnerMemberQuery recordsQuery) {
        return JsonVO.success(iBuildingOwnerService.listAll(recordsQuery));
    }

    @PostMapping("/save-Owners-members")
    @ApiOperation(value = "添加业主家庭成员")
    @Override
    public JsonVO<String> saveOwner(SaveOwnerMemberDto saveOwnerMemberDto) {
        return JsonVO.success(iBuildingOwnerService.saveOne(saveOwnerMemberDto));
    }

    @PostMapping("/update-Owners-members")
    @ApiOperation(value = "修改业主家庭成员")
    @Override
    public JsonVO<String> updateOwner(UpdateOwnerMemberDto updateOwnerMemberDto) {
        return JsonVO.success(iBuildingOwnerService.updateOne(updateOwnerMemberDto));
    }

    @PostMapping("/delete-Owners-members")
    @ApiOperation(value = "删除业主家庭成员")
    @Override
    public JsonVO<String> deleteOwner(DeleteOwnerMemberDto deleteOwnerMemberDto) {
        return JsonVO.success(iBuildingOwnerService.deleteOne(deleteOwnerMemberDto));
    }
}
