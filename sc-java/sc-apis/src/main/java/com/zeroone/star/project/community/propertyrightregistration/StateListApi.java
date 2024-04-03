package com.zeroone.star.project.community.propertyrightregistration;

import com.zeroone.star.project.vo.community.propertyrightregistration.StateVO;

import java.util.List;

/**
 * 审核状态下拉列表Api
 */
public interface StateListApi {
    List<StateVO> getStateList();
}
