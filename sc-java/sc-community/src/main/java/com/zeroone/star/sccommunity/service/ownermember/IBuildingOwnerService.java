package com.zeroone.star.sccommunity.service.ownermember;

import com.zeroone.star.project.dto.community.transactions.ownerMember.DeleteOwnerMemberDto;
import com.zeroone.star.project.dto.community.transactions.ownerMember.SaveOwnerMemberDto;
import com.zeroone.star.project.dto.community.transactions.ownerMember.UpdateOwnerMemberDto;
import com.zeroone.star.project.query.community.transactions.ownerMember.OwnerMemberQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.ownermember.OwnerMemberVO;
import com.zeroone.star.sccommunity.entity.ownermember.BuildingOwner;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zimei
 * @since 2022-10-21
 */
public interface IBuildingOwnerService extends IService<BuildingOwner> {
    PageVO<OwnerMemberVO> listAll(OwnerMemberQuery ownerMemberQuery);
    String saveOne(SaveOwnerMemberDto saveOwnerMemberDto);
    String deleteOne(DeleteOwnerMemberDto deleteOwnerMemberDto);
    String updateOne(UpdateOwnerMemberDto updateOwnerMemberDto);
}
