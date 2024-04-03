package com.zeroone.star.sccommunity.service.houseproperty.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.community.transactions.acceptHouseProperty.AcceptHousePropertyQuery;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.AcceptHousePropertyVO;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.RoomAttrDto;
import com.zeroone.star.project.vo.community.transactions.acceptHouseProperty.Rooms;
import com.zeroone.star.sccommunity.entity.houseproperty.*;
import com.zeroone.star.sccommunity.mapper.houseproperty.*;
import com.zeroone.star.sccommunity.service.houseproperty.IAcceptHousePropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author 苏乞儿
 * @Date 2022/10/24
 */
@Service
public class AcceptHousePropertyServiceImp extends ServiceImpl<AcceptHousePropertyMapper, AcceptHouseProperty> 
        implements IAcceptHousePropertyService {

    @Autowired
    HouseBuildingRoomMapper buildingRoomMapper;
    @Autowired
    HouseBuildingOwnerMapper buildingOwnerMapper;
    @Autowired
    BuildingOwnerAttrMapper buildingOwnerAttrMapper;
    @Autowired
    HouseBusinessFloorMapper businessFloorMapper;
    @Autowired
    BuildingUnitMapper buildingUnitMapper;
    @Autowired
    HouseOwnerCarMapper ownerCarMapper;
    @Autowired
    BuildingOwnerMemberDetailMapper buildingOwnerMemberDetailMapper;
    @Autowired
    AccountBankMapper accountBankMapper;
    @Autowired
    ContractRoomMapper contractRoomMapper;


    @Override
    public AcceptHousePropertyVO queryOne(AcceptHousePropertyQuery query) {
        QueryWrapper<AcceptHouseProperty> wrapper = new QueryWrapper<>();
        AcceptHouseProperty acceptHouseProperty = new AcceptHouseProperty();
        if(query.getSearchType().equals("1")){
            QueryWrapper<BuildingRoom> buildingRoomQueryWrapper = new QueryWrapper<>();
            buildingRoomQueryWrapper.eq("room_num",query.getSearchValue())
                    .eq("community_id",query.getCommunityId());
            BuildingRoom buildingRoom = buildingRoomMapper.selectOne(buildingRoomQueryWrapper);
            QueryWrapper<BuildingOwner> buildingOwnerQueryWrapper = new QueryWrapper<>();
            buildingOwnerQueryWrapper.eq("user_id",buildingRoom.getUserId());
            util(buildingOwnerQueryWrapper);
        }else if(query.getSearchType().equals("2")){
            QueryWrapper<BuildingOwner> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name",query.getSearchValue())
                    .eq("community_id",query.getCommunityId());
            util(queryWrapper);
        }else if(query.getSearchType().equals("3")){
            QueryWrapper<BuildingOwner> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("link",query.getSearchValue())
                    .eq("community_id",query.getCommunityId());
            util(queryWrapper);
        }else if(query.getSearchType().equals("4")){
            QueryWrapper<BuildingOwner> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id_card",query.getSearchValue())
                    .eq("community_id",query.getCommunityId());
            util(queryWrapper);
        }else if(query.getSearchType().equals("5")){
            QueryWrapper<OwnerCar> ownerCarQueryWrapper= new QueryWrapper<>();
            ownerCarQueryWrapper.eq("car_num",query.getSearchValue());
            OwnerCar ownerCar = ownerCarMapper.selectOne(ownerCarQueryWrapper);
            QueryWrapper<BuildingOwner> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id",ownerCar.getUserId())
                    .eq("b_id",ownerCar.getBId());
            util(queryWrapper);
        }else if(query.getSearchType().equals("6")){
            QueryWrapper<BuildingOwnerMemberDetail> buildingOwnerMemberDetailQueryWrapper = new QueryWrapper<>();
            buildingOwnerMemberDetailQueryWrapper.eq("member_name",query.getSearchValue());
            BuildingOwnerMemberDetail buildingOwnerMemberDetail1 = buildingOwnerMemberDetailMapper
                    .selectOne(buildingOwnerMemberDetailQueryWrapper);
            QueryWrapper<BuildingOwner> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("member_id",buildingOwnerMemberDetail1.getMemberId())
                    .eq("community_id",query.getCommunityId());
            util(queryWrapper);
        }else if(query.getSearchType().equals("7")){
            QueryWrapper<BuildingOwner> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("link",query.getSearchValue())
                    .eq("community_id",query.getCommunityId());
            util(queryWrapper);
        }else if(query.getSearchType().equals("8")){
            QueryWrapper<BuildingOwner> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id_card",query.getSearchValue())
                    .eq("community_id",query.getCommunityId());
            util(queryWrapper);
        }else if(query.getSearchType().equals("9")){
            QueryWrapper<AccountBank> accountBankQueryWrapper = new QueryWrapper<>();
            accountBankQueryWrapper.eq("shop_id",query.getSearchValue());
            AccountBank accountBank = accountBankMapper.selectOne(accountBankQueryWrapper);
            QueryWrapper<BuildingOwner> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name",accountBank.getPersonName())
                    .eq("link",accountBank.getPersonTel())
                    .eq("community_id",query.getCommunityId());
            util(queryWrapper);
        }else if(query.getSearchType().equals("10")){
            QueryWrapper<ContractRoom> contractRoomQueryWrapper = new QueryWrapper<>();
            contractRoomQueryWrapper.eq("",query.getSearchValue());
            ContractRoom contractRoom = contractRoomMapper.selectOne(contractRoomQueryWrapper);
            QueryWrapper<BuildingOwner> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("owner_id",contractRoom.getOwnerId())
                    .eq("community_id",query.getCommunityId());
            util(queryWrapper);
        }
        return null;
    }


    public AcceptHousePropertyVO util(QueryWrapper<BuildingOwner> wrapper){
        QueryWrapper<AcceptHouseProperty> acceptHousePropertyQueryWrapper = new QueryWrapper<>();
        AcceptHouseProperty acceptHouseProperty = new AcceptHouseProperty();
        BuildingOwner buildingOwner = buildingOwnerMapper.selectOne(wrapper);
        acceptHouseProperty.setAge(buildingOwner.getAge());
        acceptHouseProperty.setBId(buildingOwner.getBId());
        acceptHouseProperty.setCommunityId(buildingOwner.getCommunityId());
        acceptHouseProperty.setCreateTime(buildingOwner.getCreateTime());
        acceptHouseProperty.setLink(buildingOwner.getLink());
        acceptHouseProperty.setIdCard(buildingOwner.getIdCard());
        acceptHouseProperty.setMemberId(buildingOwner.getMemberId());
        acceptHouseProperty.setName(buildingOwner.getName());
        acceptHouseProperty.setOwnerFlag(buildingOwner.getOwnerFlag());
        if(buildingOwner.getSex().equals(0)){
            acceptHouseProperty.setSex("男");
        }else if (buildingOwner.getSex().equals(1)){
            acceptHouseProperty.setSex("女");
        }else {
            acceptHouseProperty.setSex(null);
        }
        acceptHouseProperty.setOwnerId(buildingOwner.getOwnerId());
        acceptHouseProperty.setOwnerTypeCd(buildingOwner.getOwnerTypeCd());
        acceptHouseProperty.setState(buildingOwner.getState());
        acceptHouseProperty.setRemark(buildingOwner.getRemark());
        acceptHouseProperty.setStatusCd(buildingOwner.getStatusCd());
        acceptHouseProperty.setUserId(buildingOwner.getUserId());
        acceptHouseProperty.setUserName(buildingOwner.getName());
        if(buildingOwner.getOwnerTypeCd().equals("1001")){
            acceptHouseProperty.setOwnerTypeName("业主本人");
        } else if (buildingOwner.getOwnerTypeCd().equals("1002")) {
            acceptHouseProperty.setOwnerTypeName("家庭成员");
        }else {
            acceptHouseProperty.setOwnerTypeName(null);
        }
        QueryWrapper<BuildingOwnerAttr> ownerAttrDtosQueryWrapper = new QueryWrapper<>();
        ownerAttrDtosQueryWrapper.eq("member_id",buildingOwner.getMemberId());
        List<BuildingOwnerAttr> ownerAttrDtos = buildingOwnerAttrMapper.selectList(ownerAttrDtosQueryWrapper);
        acceptHouseProperty.setOwnerAttrDtos(ownerAttrDtos);
        QueryWrapper<BuildingRoom> buildingRoomQueryWrapper = new QueryWrapper<>();
        buildingRoomQueryWrapper.eq("room_num",buildingOwner.getUserId())
                .eq("b_id",buildingOwner.getBId());
        BuildingRoom buildingRoom = buildingRoomMapper.selectOne(buildingRoomQueryWrapper);
        QueryWrapper<BuildingOwner> buildingOwnerQueryWrapper = new QueryWrapper<>();
        buildingOwnerQueryWrapper.eq("user_id",buildingRoom.getUserId());
        List<Rooms> rooms= null;
        for (BuildingOwnerAttr ownerAttr:
                ownerAttrDtos) {
            Rooms room = new Rooms();
            room.setRoomId(buildingRoom.getRoomId());
            room.setRoomNum(buildingRoom.getRoomNum());
            room.setCommunityId(buildingRoom.getCommunityId());
            room.setApartment(buildingRoom.getApartment());
            room.setRoomArea(buildingRoom.getRoomArea());
            room.setRoomRent(buildingRoom.getRoomRent());
            room.setRoomType(buildingRoom.getRoomType());
            room.setBuiltUpArea(buildingRoom.getBuiltUpArea());
            room.setFeeCoefficient(buildingRoom.getFeeCoefficient());
            QueryWrapper<BusinessFloor> businessFloorQueryWrapper = new QueryWrapper<>();
            businessFloorQueryWrapper.eq("b_id",buildingOwner.getBId());
            BusinessFloor businessFloor = businessFloorMapper.selectOne(businessFloorQueryWrapper);
            room.setFloorArea(businessFloor.getFloorArea());
            room.setFloorNum(businessFloor.getFloorNum());
            room.setFloorId(businessFloor.getFloorId());
            room.setLayer(buildingRoom.getLayer());
            room.setRemark(buildingOwner.getRemark());
            room.setSection(buildingRoom.getSection());
            room.setState(buildingRoom.getState());
            room.setStatusCd(buildingRoom.getStatusCd());
            room.setUnitId(buildingRoom.getUnitId());
            BuildingUnit buildingUnit = buildingUnitMapper
                    .selectOne(new QueryWrapper<BuildingUnit>()
                            .eq("unit_id",buildingRoom.getUnitId()));
            room.setUnitArea(buildingUnit.getUnitArea());
            room.setUnitNum(buildingUnit.getUnitNum());
            room.setUserId(buildingOwner.getUserId());
            List<RoomAttrDto> roomAttrDtos = null;
            for (BuildingOwnerAttr buildingOwnerAttr:
                    ownerAttrDtos) {
                RoomAttrDto roomAttrDto = new RoomAttrDto();
                roomAttrDto.setRoomId(buildingRoom.getRoomId());
                roomAttrDto.setSpecCd(buildingOwnerAttr.getSpecCd());
                roomAttrDto.setAttrId(buildingOwnerAttr.getAttrId());
                roomAttrDto.setStatusCd(buildingOwnerAttr.getStatusCd());
                roomAttrDtos.add(roomAttrDto);
            }
            room.setRoomAttrDto(roomAttrDtos);
            rooms.add(room);
        }
        acceptHouseProperty.setRooms(rooms);
        AcceptHousePropertyVO acceptHousePropertyVO = new AcceptHousePropertyVO();
        BeanUtil.copyProperties(acceptHouseProperty,AcceptHousePropertyVO.class);
        return acceptHousePropertyVO;
    }
}
