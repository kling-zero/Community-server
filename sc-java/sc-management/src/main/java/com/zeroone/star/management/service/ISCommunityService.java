package com.zeroone.star.management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.management.entity.CityArea;
import com.zeroone.star.project.query.management.CityAreaQuery;
import com.zeroone.star.project.vo.management.CityAreaVO;
import com.zeroone.star.project.vo.management.SCommunityVO;
import java.util.List;
import com.zeroone.star.project.query.management.CommunityQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.management.entity.SCommunity;
import com.zeroone.star.project.dto.management.CommunityDTO;
import com.zeroone.star.project.dto.management.ModifyCommunityDTO;

/**
 * <p>
 *  小区操作 服务类
 * </p>
 *
 * @author j4
 * @since 2022-10-16
 */
public interface ISCommunityService extends IService<SCommunity> {
    /**
     * 添加小区
     *
     * @param communityDTO 小区实体类
     * @return 返回true表示新增成功 返回false表示新增失败
     */
    boolean saveCommunity(CommunityDTO communityDTO);
    /**
     * 获取无物业管理的小区
     * @return 小区列表
     */
    List<SCommunityVO> selectNoEnterCommunity();
    /**
     * 分页 条件查询 所有数据（如果没有传数据就是查所有）
     * @param query 查询条件对象
     * @return 查询结果
     */
    PageVO<SCommunityVO> listByCondition(CommunityQuery query);

    /**
     * 修改小区
     *
     * @param modifyCommunityDTO 小区实体类
     * @return 返回true表示新增成功 返回false表示新增失败
     */
    boolean updateCommunity(ModifyCommunityDTO modifyCommunityDTO);
    /**
     * 通过Name获得小区信息
     * @param name 小区Name
     * @return 小区信息
     */
    SCommunity getCommunityByName(String name);

}
