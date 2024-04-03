package com.zeroone.star.project.community.transactions.listOwnerMember;

import com.zeroone.star.project.dto.community.transactions.ownerMember.DeleteOwnerMemberDto;
import com.zeroone.star.project.dto.community.transactions.ownerMember.SaveOwnerMemberDto;
import com.zeroone.star.project.dto.community.transactions.ownerMember.UpdateOwnerMemberDto;
import com.zeroone.star.project.query.community.transactions.ownerMember.OwnerMemberQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.ownermember.OwnerMemberVO;

/**
 * 家庭成员
 */
public interface OwnerMemberApis {
    /**
     * 查询业主家庭成员
     * @param condition
     * @return
     */
    JsonVO<PageVO<OwnerMemberVO>> queryAll(OwnerMemberQuery condition);

    /**
     * 添加业主家庭成员
     * @param saveOwnerMemberDto
     * @return
     */
    JsonVO<String> saveOwner(SaveOwnerMemberDto saveOwnerMemberDto);

    /**
     * 修改业主家庭成员
     * @param saveOwnerMemberDto
     * @return
     */
    JsonVO<String> updateOwner(UpdateOwnerMemberDto saveOwnerMemberDto);
    /**
     * 删除业主家庭成员
     * @param deleteOwnerMemberDto
     * @return
     */
    JsonVO<String> deleteOwner(DeleteOwnerMemberDto deleteOwnerMemberDto);


}
