package com.zeroone.star.sccommunity.service.complaintmanagement.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.query.community.transactions.complaintmanagement.ComplaintManageQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.complaintmanagement.ComplaintManageVO;
import com.zeroone.star.sccommunity.entity.complaintmanagement.BusinessComplaint;
import com.zeroone.star.sccommunity.entity.dict.TDict;
import com.zeroone.star.sccommunity.mapper.complaintmanagement.BusinessComplaintMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.sccommunity.mapper.dict.DictTDictMapper;
import com.zeroone.star.sccommunity.service.complaintmanagement.IBusinessComplaintService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Gerins
 * @since 2022-10-15
 */
@Service
public class BusinessComplaintServiceImpl extends ServiceImpl<BusinessComplaintMapper, BusinessComplaint> implements IBusinessComplaintService {

    @Autowired
    BusinessComplaintMapper businessComplaintMapper;

    @Autowired
    DictTDictMapper tDictMapper;

    @Override
    public PageVO<ComplaintManageVO> listByCondition(ComplaintManageQuery condition) {
        // 返回的Page对象
        Page<ComplaintManageVO> resultPage = new Page<>();

        Page<BusinessComplaint> pageInfo = new Page<>(condition.getPage(), condition.getRow());
        LambdaQueryWrapper<BusinessComplaint> businessComplaintLambdaQueryWrapper = new LambdaQueryWrapper<>();
        businessComplaintLambdaQueryWrapper.eq(BusinessComplaint::getCommunityId, condition.getCommunityId())
                .eq(BusinessComplaint::getRoomId, condition.getRoomId());
        businessComplaintMapper.selectPage(pageInfo, businessComplaintLambdaQueryWrapper);

        BeanUtils.copyProperties(pageInfo, resultPage, "records");

        List<BusinessComplaint> records = pageInfo.getRecords();

        List<ComplaintManageVO> complaintManageVOList = records.stream().map((item) -> {
            ComplaintManageVO complaintManageVO = new ComplaintManageVO();

            BeanUtils.copyProperties(item, complaintManageVO);

            complaintManageVO.setCurrentUserId("");
            complaintManageVO.setCurrentUserName("");
            complaintManageVO.setCurrentUserTel("");
            complaintManageVO.setPhotos(null);

            LambdaQueryWrapper<TDict> tDictLambdaQueryWrapper = new LambdaQueryWrapper<>();
            tDictLambdaQueryWrapper.eq(TDict::getStatusCd, complaintManageVO.getTypeCdName());
            TDict tDict = tDictMapper.selectOne(tDictLambdaQueryWrapper);
            String typeCdName = tDict.getName();

            complaintManageVO.setTypeCdName(typeCdName);

            /* 无意义字段
            "unitNum":"1"		查表
            "roomNum":"1",		查表

            没找到表
            "stateName":"处理完成"
            */
            complaintManageVO.setStateName("处理完成");

            return complaintManageVO;
        }).collect(Collectors.toList());

        resultPage.setRecords(complaintManageVOList);

        return PageVO.create(resultPage);
    }
}
