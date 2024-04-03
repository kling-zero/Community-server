package com.zeroone.star.project.community.propertyrightregistration;

import com.zeroone.star.project.vo.community.propertyrightregistration.FloorVO;

import java.util.List;

/**
 * 楼栋下拉列表Api
 */
public interface FloorListApi {
    List<FloorVO> getFloorList();
}
