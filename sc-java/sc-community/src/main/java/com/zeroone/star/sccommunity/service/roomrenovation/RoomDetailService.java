package com.zeroone.star.sccommunity.service.roomrenovation;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.community.roomRenovation.DetailRenovationQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.roomRenovation.DetailRenovationVO;
import com.zeroone.star.sccommunity.entity.roomrenovation.RoomDetail;

import java.util.List;

public interface RoomDetailService extends IService<RoomDetail> {
    PageVO<DetailRenovationVO> queryDetailAllById(DetailRenovationQuery condition);
}
