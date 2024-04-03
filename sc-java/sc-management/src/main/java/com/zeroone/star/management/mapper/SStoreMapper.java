package com.zeroone.star.management.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.management.entity.SCommunity;
import com.zeroone.star.management.entity.SProperty;
import com.zeroone.star.management.entity.SStore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.project.query.management.CommunityQuery;
import com.zeroone.star.project.query.management.PropertyQuery;
import com.zeroone.star.project.vo.management.SCommunityVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author j4
 * @since 2022-10-16
 */
@Mapper
public interface SStoreMapper extends BaseMapper<SStore> {


    /**
     * 分页查询物业
     * @param page 分页
     * @param condition 查询条件
     * @return 物业对象的分页查询结果
     */
    Page<SStore> listPropertyByCondition(Page<SStore> page, @Param("condition") PropertyQuery condition);

    /**
     * 查询某物业管理的小区
     * @param page
     * @param communityQuery 查询条件
     * @return 物业管理的小区列表
     */
    Page<SCommunity> queryBelongingCommunities(Page<SCommunity> page, @Param("condition") CommunityQuery communityQuery);
}
