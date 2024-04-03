package com.zeroone.star.sccommunity.service.ownermember.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.community.transactions.ownerMember.DeleteOwnerMemberDto;
import com.zeroone.star.project.dto.community.transactions.ownerMember.SaveOwnerMemberDto;
import com.zeroone.star.project.dto.community.transactions.ownerMember.UpdateOwnerMemberDto;
import com.zeroone.star.project.query.community.transactions.ownerMember.OwnerMemberQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.ownermember.OwnerMemberVO;
import com.zeroone.star.sccommunity.entity.ownermember.BuildingOwner;
import com.zeroone.star.sccommunity.mapper.ownermember.BuildingOwnerMapper;
import com.zeroone.star.sccommunity.service.ownermember.IBuildingOwnerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zimei
 * @since 2022-10-21
 */
@Service
public class BuildingOwnerServiceImpl extends ServiceImpl<BuildingOwnerMapper, BuildingOwner> implements IBuildingOwnerService {
    @Autowired
    BuildingOwnerMapper buildingOwnerMapper;

    @Override
    public PageVO<OwnerMemberVO> listAll(OwnerMemberQuery ownerMemberQuery) {
        //构建分页对象
        Page<BuildingOwner> page = new Page<>(ownerMemberQuery.getPageIndex(), ownerMemberQuery.getPageSize());
        //构建条件对象
        LambdaQueryWrapper<BuildingOwner> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BuildingOwner::getOwnerId, ownerMemberQuery.getOwnerId())
                .eq(BuildingOwner::getCommunityId, ownerMemberQuery.getCommunityId());
        //执行分页查询
        Page<BuildingOwner> pages = buildingOwnerMapper.selectPage(page, queryWrapper);

        for (BuildingOwner buildingOwner : pages.getRecords()) {
            if ("1001".equals(buildingOwner.getOwnerTypeCd())) {
                buildingOwner.setOwnerTypeCd("业主本人");
            } else if ("1002".equals(buildingOwner.getOwnerTypeCd())) {
                buildingOwner.setOwnerTypeCd("家庭成员");
            } else if ("1003".equals(buildingOwner.getOwnerTypeCd())) {
                buildingOwner.setOwnerTypeCd("房屋租客");
            }
        }

        return PageVO.create(pages, OwnerMemberVO.class);
    }

    @Override
    public String saveOne(SaveOwnerMemberDto saveOwnerMemberDto) {
        //传输数据
        BuildingOwner buildingOwner = new BuildingOwner();

        buildingOwner.setOwnerId(saveOwnerMemberDto.getOwnerId());

        if ("女".equals(saveOwnerMemberDto.getSex())||"1".equals(saveOwnerMemberDto.getSex()))
            buildingOwner.setSex(1);
        else
            buildingOwner.setSex(0);

        buildingOwner.setAge(Integer.parseInt(saveOwnerMemberDto.getAge()));
        buildingOwner.setOwnerFlag("T");
        buildingOwner.setLink(saveOwnerMemberDto.getLink());
        buildingOwner.setAddress("");

        if("房屋租客".equals(saveOwnerMemberDto.getOwnerTypeCd()))
            buildingOwner.setOwnerTypeCd("1003");
        else if ("家庭成员".equals(saveOwnerMemberDto.getOwnerTypeCd())) {
            buildingOwner.setOwnerTypeCd("1002");
        }else if("业主本人".equals(saveOwnerMemberDto.getOwnerTypeCd())){
            buildingOwner.setOwnerTypeCd("1001");
        }else {
            buildingOwner.setOwnerTypeCd("未知");
        }

        buildingOwner.setState("1000");
        buildingOwner.setName(saveOwnerMemberDto.getName());
        buildingOwner.setIdCard(saveOwnerMemberDto.getIdCard());
        buildingOwner.setBId("202022081704610005");
        buildingOwner.setRemark(saveOwnerMemberDto.getRemark());
        buildingOwner.setStatusCd("0");
        buildingOwner.setCreateTime(LocalDateTime.now());
        buildingOwner.setMemberId(saveOwnerMemberDto.getMemberId());
        buildingOwner.setUserId(saveOwnerMemberDto.getOwnerId());
        buildingOwner.setCommunityId(saveOwnerMemberDto.getCommunityId());
        //构建条件对象
        buildingOwnerMapper.insert(buildingOwner);
        return "操作成功";
    }

    @Override
    public String deleteOne(DeleteOwnerMemberDto deleteOwnerMemberDto) {
        QueryWrapper<BuildingOwner> buildingOwnerQueryWrapper = new QueryWrapper<>();
        buildingOwnerQueryWrapper.eq("member_id",deleteOwnerMemberDto.getMemberId());
        buildingOwnerMapper.delete(buildingOwnerQueryWrapper);
        return "操作成功";
    }

    @Override
    public String updateOne(UpdateOwnerMemberDto updateOwnerMemberDto) {
        UpdateWrapper<BuildingOwner> buildingOwnerUpdateWrapper = new UpdateWrapper<>();
        buildingOwnerUpdateWrapper.eq("member_id",updateOwnerMemberDto.getMemberId());

        BuildingOwner buildingOwner = new BuildingOwner();
        buildingOwner.setOwnerId(updateOwnerMemberDto.getOwnerId());

        if ("女".equals(updateOwnerMemberDto.getSex())||"1".equals(updateOwnerMemberDto.getSex()))
            buildingOwner.setSex(1);
        else
            buildingOwner.setSex(0);

        buildingOwner.setAge(Integer.parseInt(updateOwnerMemberDto.getAge()));
        buildingOwner.setOwnerFlag("T");
        buildingOwner.setLink(updateOwnerMemberDto.getLink());
        buildingOwner.setAddress("");

        if("房屋租客".equals(updateOwnerMemberDto.getOwnerTypeCd()))
            buildingOwner.setOwnerTypeCd("1003");
        else if ("家庭成员".equals(updateOwnerMemberDto.getOwnerTypeCd())) {
            buildingOwner.setOwnerTypeCd("1002");
        }else if("业主本人".equals(updateOwnerMemberDto.getOwnerTypeCd())){
            buildingOwner.setOwnerTypeCd("1001");
        }else {
            buildingOwner.setOwnerTypeCd("未知");
        }

        buildingOwner.setState("1000");
        buildingOwner.setName(updateOwnerMemberDto.getName());
        buildingOwner.setIdCard(updateOwnerMemberDto.getIdCard());
        buildingOwner.setBId("202022081704610005");
        buildingOwner.setRemark(updateOwnerMemberDto.getRemark());
        buildingOwner.setStatusCd("0");
        buildingOwner.setCreateTime(LocalDateTime.now());
        buildingOwner.setMemberId(updateOwnerMemberDto.getMemberId());
        buildingOwner.setUserId(updateOwnerMemberDto.getOwnerId());
        buildingOwner.setCommunityId(updateOwnerMemberDto.getCommunityId());

        buildingOwnerMapper.update(buildingOwner,buildingOwnerUpdateWrapper);
        return "操作成功";
    }
}
