package com.zeroone.star.project.setting;


import com.zeroone.star.project.dto.setting.MemberInfoDto;
import com.zeroone.star.project.query.setting.MemberQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.setting.MemberFullInfoVo;
import com.zeroone.star.project.vo.setting.MemberSimpleInfoVo;
import io.swagger.annotations.ApiModelProperty;

/**
* @Description 员工信息外部接口
*/
public interface MemberInfoApis {


    @ApiModelProperty(value = "查询员工信息列表")
    JsonVO<PageVO<MemberSimpleInfoVo>> getMemberInfoList(MemberQuery memberQuery);

    @ApiModelProperty(value = "获取员工的完整信息")
    JsonVO<MemberFullInfoVo> getMemberFullInfo(Long id);

    @ApiModelProperty(value = "添加员工信息")
    JsonVO addMemberInfo(MemberInfoDto memberInfoDto);

    @ApiModelProperty(value = "删除员工信息")
    JsonVO deleteMemberInfo(Long id);

    @ApiModelProperty(value = "重置员工密码为随机六位数")
    JsonVO<String> resetPassword(Long id);

}
