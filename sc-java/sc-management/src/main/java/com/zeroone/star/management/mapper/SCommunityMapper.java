package com.zeroone.star.management.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.management.entity.SCommunity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroone.star.project.vo.management.SCommunityVO;
import com.zeroone.star.project.query.management.CommunityQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author j4
 * @since 2022-10-16
 */
@Mapper
public interface SCommunityMapper extends BaseMapper<SCommunity> {

    /**
     * 查询所有无物业管理的小区
     * @return 小区列表
     */
    List<SCommunityVO> selectNoEnterCommunity();
    /**
     * 根据条件查询小区（条件如果是空就是查全部）
     * @param page
     * @param condition 查询条件
     * @return
     */
    Page<SCommunityVO> listByCondition(Page<SCommunityVO> page,@Param("condition") CommunityQuery condition);

}
