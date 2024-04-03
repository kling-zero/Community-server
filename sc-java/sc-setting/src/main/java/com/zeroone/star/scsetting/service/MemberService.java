package com.zeroone.star.scsetting.service;


import com.zeroone.star.project.dto.setting.MemberInfoDto;
import com.zeroone.star.project.query.setting.MemberQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.setting.MemberFullInfoVo;
import com.zeroone.star.project.vo.setting.MemberSimpleInfoVo;

/**
 * @BelongsProject: zero-one-smart-community
 * @BelongsPackage: com.zeroone.star.scsetting.service
 * @Author: sensfloron
 * @CreateTime: 2022-10-14  22:06
 * @Description:
 * @Version: 1.0
 */

public interface MemberService {
    /**
     * @Description 获取员工信息列表
     * @Param MemberQuery
     * @Return PageVO<MemberInfoVo>
     */
    PageVO<MemberSimpleInfoVo> getInfoList(MemberQuery query);

    /**
     * @Description 查询员工关联的详细信息
     * @Param 员工编号ID
     * @Return 员工关联信息
     */
    MemberFullInfoVo getMemberFullInfo(Long id);

    // 添加员工，检验手机号是否存在,throw自定义错误交给controller处理响应码，比如手机号已经存在

    /**
     * @Description 添加员工信息
     * @Param MemberInfoDto
     * @Return void
     */
    void addMemberInfo(MemberInfoDto memberInfoDto) throws Exception;

    /**
     * @Description 删除单个员工信息
     * @Param 员工ID
     * @Return void
     */
    void deleteMemberInfo(Long id);

    /**
     * @Description 重置该员工的密码为随机6位数
     * @Param 员工id
     * @Return 生成的密码
     */
    String resetPassword(Long id) throws Exception;
}