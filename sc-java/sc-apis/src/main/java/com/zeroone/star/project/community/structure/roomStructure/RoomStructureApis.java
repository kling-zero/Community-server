package com.zeroone.star.project.community.structure.roomStructure;


import com.zeroone.star.project.query.community.structure.roomStructure.RoomStructureQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.structure.roomStructure.RoomStructureVO;

/**
 * @Description 楼栋结构查询api
 * @Author 苏乞儿
 * @Date 2022/10/14
 */

public interface RoomStructureApis {

    /**
     * 楼栋结构分页查询
     * @param condition 查询条件
     * @return 查询结果
     */

    JsonVO<PageVO<RoomStructureVO>> queryAll(RoomStructureQuery condition);

}
