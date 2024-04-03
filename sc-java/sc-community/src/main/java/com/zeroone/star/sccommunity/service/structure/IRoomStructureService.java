package com.zeroone.star.sccommunity.service.structure;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.community.structure.roomStructure.RoomStructureQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.structure.roomStructure.RoomStructureVO;
import com.zeroone.star.sccommunity.entity.structure.RoomStructure;

public interface IRoomStructureService extends IService<RoomStructure> {

    PageVO<RoomStructureVO> listByCondition(RoomStructureQuery query);
}
