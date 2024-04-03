package com.zeroone.star.project.community.roomRenovation;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.community.roomRenovation.DeleteBasicDTO;
import com.zeroone.star.project.dto.community.roomRenovation.RoomBasicDTO;
import com.zeroone.star.project.dto.community.roomRenovation.SaveBasicDTO;
import com.zeroone.star.project.dto.community.roomRenovation.UpdateBasicDTO;
import com.zeroone.star.project.query.community.roomRenovation.BasicRenovationQuery;
import com.zeroone.star.project.query.community.roomRenovation.DetailRenovationQuery;
import com.zeroone.star.project.query.community.roomRenovation.RecordRenovationQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.roomRenovation.BasicRenovationVO;
import com.zeroone.star.project.vo.community.roomRenovation.DetailRenovationVO;
import com.zeroone.star.project.vo.community.roomRenovation.RecordRenovationVO;

import java.util.List;

/**
 * 房间装修api
 *
 * @author ahu
 * @date 2022/10/15
 */
public interface RoomRenovationApis {
    /**
     * 查询所有房屋基本信息
     *
     * @param condition 条件
     * @return {@code JsonVO<PageVO<BasicRenovationVO>>}
     */
    JsonVO<PageVO<BasicRenovationVO>> queryAll(BasicRenovationQuery condition);


    /**
     * 更新装修基本信息
     *
     * @param condition 条件
     * @return {@code JsonVO<String>}
     */
    JsonVO<String> updateBasic(RoomBasicDTO condition);

    /**
     * 保存装修基本信息
     *
     * @param condition 条件
     * @return {@code JsonVO<String>}
     */
    JsonVO<String> saveBasic(RoomBasicDTO condition);

    /**
     * 删除装修基本信息
     *
     * @param condition 条件
     * @return {@code JsonVO<String>}
     */
    JsonVO<String> deleteBasic(RoomBasicDTO condition);

    /**
     * 查询id
     *
     * @param id id
     * @return {@code JsonVO<PageVO<BasicRenovationVO>>}
     */
    JsonVO<BasicRenovationVO> queryId(int id);


    /**
     * 查询房屋验收明细信息
     *
     * @param condition 条件
     * @return {@code JsonVO<PageVO<DetailRenovationVO>>}
     */
    JsonVO<PageVO<DetailRenovationVO>> queryDetailAllById(DetailRenovationQuery condition);

    /**
     * 查询房屋追踪记录
     *
     * @param condition 条件
     * @return {@code JsonVO<PageVO<RecordRenovationVO>>}
     */
    JsonVO<PageVO<RecordRenovationVO>> queryRecordAllById(RecordRenovationQuery condition);


    /**
     * 删除房屋追踪记录
     *
     * @param condition 条件
     * @return {@code JsonVO<String>}
     */
    JsonVO<String> deleteRecord(RecordRenovationQuery condition);

    /**
     * 查询追踪记录详情
     *
     * @param condition 条件
     * @return {@code JsonVO<PageVO<RecordRenovationVO>>}
     */
    JsonVO<PageVO<RecordRenovationVO>> queryRecordDetail(RecordRenovationQuery condition);



}
