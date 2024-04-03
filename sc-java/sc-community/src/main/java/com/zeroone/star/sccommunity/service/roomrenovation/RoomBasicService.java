package com.zeroone.star.sccommunity.service.roomrenovation;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.dto.community.roomRenovation.RoomBasicDTO;
import com.zeroone.star.project.query.community.roomRenovation.BasicRenovationQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.roomRenovation.BasicRenovationVO;
import com.zeroone.star.sccommunity.entity.roomrenovation.RoomBasic;

public interface RoomBasicService extends IService<RoomBasic> {
    void saveBasic(RoomBasicDTO condition);

    void deleteBasic(RoomBasicDTO condition);

    void updateBasic(RoomBasicDTO condition);

    PageVO<BasicRenovationVO> queryAll(BasicRenovationQuery condition);
}
