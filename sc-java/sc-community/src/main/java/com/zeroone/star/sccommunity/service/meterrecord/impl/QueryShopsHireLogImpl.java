package com.zeroone.star.sccommunity.service.meterrecord.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.sample.communitymanage.busaccept.meterrecords.QueryShopsHireLogQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.meterrecords.QueryShopsHireLogVO;
import com.zeroone.star.sccommunity.entity.buildingfee.Fees;
import com.zeroone.star.sccommunity.entity.meterrecord.QueryShopsHireLog;
import com.zeroone.star.sccommunity.entity.structure.BuildingRoom;
import com.zeroone.star.sccommunity.entity.structure.TDict;
import com.zeroone.star.sccommunity.mapper.meterrecord.QueryShopsHireLogMapper;
import com.zeroone.star.sccommunity.service.buildingfee.IFeeService;
import com.zeroone.star.sccommunity.service.meterrecord.IQueryShopsHireLogService;
import com.zeroone.star.sccommunity.service.structure.IBuildingRoomService;
import com.zeroone.star.sccommunity.service.structure.ITDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QueryShopsHireLogImpl extends ServiceImpl<QueryShopsHireLogMapper, QueryShopsHireLog> implements IQueryShopsHireLogService {
    @Autowired
    QueryShopsHireLogMapper queryShopsHireLogMapper;
    @Autowired
    IBuildingRoomService buildingRoomService;
    @Autowired
    IFeeService feeService;
    @Autowired
    ITDictService itDictService;

    //通过communityId和RoomNum进行查询，先查到user_id列表，说明这个房间曾被哪些用户使用
    // ，再通过user_id来查fee_id，一个用户可能对应多个订单，因为可能多次租用
    // 再通过fee——id来查meter_water的数据；
    @Override
    public PageVO<QueryShopsHireLogVO> selectByCommunityIdRoomNum(QueryShopsHireLogQuery condition) {
        //1.通过communityId和RoomNum进行查询，先查到user_id列表
        /*
        Page<QueryShopsHireLog> queryShopsHireLogPage = new Page<>(condition.getPageIndex(), condition.getPageSize());
        QueryWrapper<QueryShopsHireLog> wrapper = new QueryWrapper<>();
        wrapper.eq("community_id",condition.getCommunityId()).eq("room_num",condition.getRoomNum());
        Page<QueryShopsHireLog> page = queryShopsHireLogMapper.selectPage(queryShopsHireLogPage, wrapper);
         */
        List<String> list = buildingRoomService.selectByCommunityIdRoomNum(condition);

        //2.通过user_id查询fee_id,得到房间的所有订单
        List<String> listFeeId = feeService.selectByUserId(list);

        //3.然后通过订单来获取信息；
        Page<QueryShopsHireLog> queryShopsHireLogPage = new Page<>(condition.getPageIndex(), condition.getPageSize());
        QueryWrapper<QueryShopsHireLog> wrapper = new QueryWrapper<>();
        wrapper.in("fee_id",listFeeId);
        Page<QueryShopsHireLog> page = queryShopsHireLogMapper.selectPage(queryShopsHireLogPage, wrapper);
        //将剩余的属性值进行查询封装
        for (QueryShopsHireLog log : page.getRecords()) {
            //1.根据fee_id查回uer_id,一个feeId对应一个UserId，一个UserId对应多个feeId
            String userId = feeService.selectByFeeId(log.getFeeId());
            log.setUserId(userId);
            //2.通过userId获取building_room的数据
            BuildingRoom buildingRoom = buildingRoomService.selectById( userId);
            if (buildingRoom != null){
                log.setCommunityId(buildingRoom.getCommunityId());
                log.setCreateTime(buildingRoom.getCreateTime());
                log.setRemark(buildingRoom.getRemark());
                log.setStatusCd(buildingRoom.getStatusCd());
            }else {
                log.setCommunityId("");
                log.setCreateTime(null);
                log.setRemark("");
                log.setStatusCd("");
            }
            //状态码的转换
            //MeterTypeName
            TDict tDict = itDictService.selectByStatus(log.getMeterType(), "meter_water", "meter_type");
            if (tDict != null){
                log.setMeterTypeName(tDict.getName());
            }else {
                log.setMeterTypeName("");
            }
            TDict tDict1 = itDictService.selectByStatus(log.getStatusCd(), "all", "status_cd");
            if (tDict1 != null){
                log.setStatusCd(tDict1.getName());
            }else {
                log.setStatusCd("");
            }
        }

        return PageVO.create(page,QueryShopsHireLogVO.class);
    }
}
