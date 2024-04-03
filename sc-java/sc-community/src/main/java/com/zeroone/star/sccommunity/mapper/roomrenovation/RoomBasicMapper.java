package com.zeroone.star.sccommunity.mapper.roomrenovation;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.sccommunity.entity.roomrenovation.RoomBasic;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@TableName("room_renovation")
public interface RoomBasicMapper extends BaseMapper<RoomBasic> {
}
