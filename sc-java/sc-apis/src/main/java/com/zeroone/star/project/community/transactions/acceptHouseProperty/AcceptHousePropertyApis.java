package com.zeroone.star.project.community.transactions.acceptHouseProperty;

import com.zeroone.star.project.dto.community.myCommunity.SavaHandOverDTO;
import com.zeroone.star.project.query.community.transactions.acceptHouseProperty.AcceptHousePropertyQuery;
import com.zeroone.star.project.query.community.transactions.acceptHouseProperty.OwnersQuery;
import com.zeroone.star.project.query.community.transactions.acceptHouseProperty.PayFeeConfigQuery;
import com.zeroone.star.project.query.community.transactions.acceptHouseProperty.RoomCreateFeeAddQuery;
import com.zeroone.star.project.query.community.structure.roomStructure.RoomStructureQuery;
import com.zeroone.star.project.query.community.structure.roomStructure.unitsAndFloor.UnitsAndFloorQuery;
import com.zeroone.star.project.query.community.structure.userMenu.UserMenuQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.structure.carStructure.unitsAndFloor.UnitsAndFloorVO;
import com.zeroone.star.project.vo.community.structure.carStructure.userMenu.UserMenuVO;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.*;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/15
 */

public interface AcceptHousePropertyApis {
    /**
     * 分页查询受理业主信息
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<AcceptHousePropertyVO> queryOne(AcceptHousePropertyQuery condition);

    /**
     * 查询受理小区所有单元
     * @param condition 查询条件
     * @return 查询结果
     */

    JsonVO<PageVO<UnitsAndFloorVO>> queryAllUnits(UnitsAndFloorQuery condition);

    /**
     * 查询受理小区树状结构图
     * @param condition 查询条件
     * @return 查询结果
     */

    JsonVO<PageVO<RoomTreeStructureVO>> queryAllRoomTreeStructure(RoomStructureQuery condition);

    /**
     * 查询用户菜单
     * @param condition 查询条件
     * @return 查询结果
     */

    JsonVO<PageVO<UserMenuVO>> queryListMenuUser(UserMenuQuery condition);

    /**
     * 交房和退房付费查询
     * @param condition 查询条件
     * @return 查询结果
     */

    JsonVO<PayFeeConfigVO> queryPayFeeConfig(PayFeeConfigQuery condition);

    /**
     * 交房信息表查询
     * @param condition 查询条件
     * @return 查询结果
     */

    JsonVO<PageVO<RoomCreateFeeAddVO>> addRoomCreateFee(RoomCreateFeeAddQuery condition);

    /**
     * 交房信息表添加
     * @param data 数据传输对象
     * @return 传输结果
     */
    JsonVO saveHandOver(SavaHandOverDTO data);
    /**
     * 房屋拥有者查询
     * @param condition 查询条件
     * @return 查询结果
     */

    JsonVO<PageVO<OwnersVO>> queryAllOwners(OwnersQuery condition);


    /**
     * 创建房间费用账单查询
     * @param condition 查询条件
     * @return 查询结果
     */

    JsonVO<PageVO<RoomCreateFeeAddVO>> queryAllRoomsFee(RoomCreateFeeAddQuery condition);
}
