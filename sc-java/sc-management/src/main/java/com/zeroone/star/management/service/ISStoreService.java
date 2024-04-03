package com.zeroone.star.management.service;

import com.zeroone.star.management.entity.SStore;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.management.CommunityQuery;
import com.zeroone.star.project.query.management.PropertyQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.management.PropertyVO;
import com.zeroone.star.project.dto.management.PropertyDTO;
import com.zeroone.star.project.dto.management.UpdatePropertyDTO;
import com.zeroone.star.project.dto.management.PropertyStateDTO;
import com.zeroone.star.project.vo.management.SCommunityVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author codercled、jiemo、qingfeng
 * @since 2022-10-16
 */
public interface ISStoreService extends IService<SStore> {
    /**
     * 查询符合条件的物业，分页查询
     * @param condition 查询条件
     * @return 查询结果
     */
    PageVO<PropertyVO> listPropertyByCondition(PropertyQuery condition);
     /**
     * 重置物业管理员密码
     * @param propertyDTO
     * @return
     */
    String randomUpdatePwd(PropertyDTO propertyDTO);

    /**
     * 加入小区
     * @param propertyDTO
     * @return
     */
    String saveCommunity(PropertyDTO propertyDTO);
    /**
     * 添加物业
     * @param PropertyDTO 物业信息
     * @return 查询结果
     */
    int insertProperty(PropertyDTO PropertyDTO);

    /**
     * 修改物业信息
     * @param updatePropertyDTO 物业信息
     * @return 查询结果
     */
    int updatePropertyByID(UpdatePropertyDTO updatePropertyDTO);

    /**
     * 修改物业登录状态
     * @param propertyStateDTO
     * @return
     */
    boolean updateState(PropertyStateDTO propertyStateDTO);

    /**
     * 删除物业公司根据id
     * @param storeId
     * @return
     */
    boolean removePropertyById(String storeId);

    /**
     *
     * @param communityQuery
     * @return
     */
    PageVO<SCommunityVO> queryBelongingCommunities(CommunityQuery communityQuery);
}
