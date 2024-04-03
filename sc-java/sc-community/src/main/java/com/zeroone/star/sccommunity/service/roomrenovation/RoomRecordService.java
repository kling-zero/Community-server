package com.zeroone.star.sccommunity.service.roomrenovation;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.community.roomRenovation.RecordRenovationQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.roomRenovation.RecordRenovationVO;
import com.zeroone.star.sccommunity.entity.roomrenovation.RoomRecord;

public interface RoomRecordService extends IService<RoomRecord> {
    void deleteRecord(RecordRenovationQuery condition);

    void queryRecordDetail();

    PageVO<RecordRenovationVO> queryRecordAllById(RecordRenovationQuery condition);
}
