package com.zeroone.star.sccommunity.service.reprintreceipt.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.query.community.transactions.reprintreceipt.ReceiptQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.reprintreceipt.FeeTypeVO;
import com.zeroone.star.project.vo.community.transactions.reprintreceipt.ReprintReceiptVO;
import com.zeroone.star.sccommunity.entity.carinfo.BuildingOwner;
import com.zeroone.star.sccommunity.entity.carinfo.OwnerCar;
import com.zeroone.star.sccommunity.entity.carinfo.ParkingSpace;
import com.zeroone.star.sccommunity.entity.reprintreceipt.BuildingRoom;
import com.zeroone.star.sccommunity.entity.reprintreceipt.PayFee;
import com.zeroone.star.sccommunity.entity.reprintreceipt.PayFeeConfig;
import com.zeroone.star.sccommunity.mapper.reprintreceipt.PayFeeMapper;
import com.zeroone.star.sccommunity.service.carinfo.IBuildingOwnerService;
import com.zeroone.star.sccommunity.service.carinfo.IOwnerCarService;
import com.zeroone.star.sccommunity.service.carinfo.IParkingSpaceService;
import com.zeroone.star.sccommunity.service.reprintreceipt.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author night
 * @since 2022-10-24
 */
@Service
public class PayFeeServiceImpl extends ServiceImpl<PayFeeMapper, PayFee> implements IPayFeeService {

    @Autowired
    private IPayFeeConfigService payFeeConfigService;
    @Autowired
    private IParkingSpaceService parkingSpaceService;
    @Autowired
    private IOwnerCarService ownerCarService;
    @Autowired
    private IBuildingOwnerService buildingOwnerService;
    @Autowired
    private IBuildingRoomService buildingRoomService;

    /**
     * 查询收据列表
     * @param receiptQuery 查询条件
     * @return 收据列表分页对象
     */
    @Override
    public PageVO<ReprintReceiptVO> getAll(ReceiptQuery receiptQuery) {
        //查询条件
        Page<PayFee> page = new Page<>(receiptQuery.getPageIndex(), receiptQuery.getPageSize());
        LambdaQueryWrapper<PayFee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PayFee::getCommunityId, receiptQuery.getCommunityId());
        queryWrapper.eq(PayFee::getFeeTypeCd, receiptQuery.getCostType());

        //执行查询
        Page<PayFee> payFeePage = baseMapper.selectPage(page, queryWrapper);

        //根据查询的类型绑定条件
        switch (receiptQuery.getCostType()) {
            //房屋费
            case "01":
                //设置房屋名
                for (PayFee payFee : payFeePage.getRecords()) {
                    LambdaQueryWrapper<BuildingRoom> roomQuery = new LambdaQueryWrapper<>();
                    roomQuery.eq(BuildingRoom::getRoomId, receiptQuery.getRoomId());
                    BuildingRoom buildingRoom = buildingRoomService.getOne(roomQuery);
                    payFee.setRoomName(buildingRoom.getRoomNum());
                }
                break;

            //车位费
            case "02":
                //设置车位
                for (PayFee payFee : payFeePage.getRecords()) {
                    //查询车辆
                    String userId = payFee.getUserId();
                    LambdaQueryWrapper<OwnerCar> carQuery = new LambdaQueryWrapper<>();
                    carQuery.eq(OwnerCar::getUserId, userId);
                    OwnerCar car = ownerCarService.getOne(carQuery);

                    //查询车位
                    String psId = car.getPsId();
                    LambdaQueryWrapper<ParkingSpace> psQuery = new LambdaQueryWrapper<>();
                    psQuery.eq(ParkingSpace::getPsId, psId);
                    ParkingSpace ps = parkingSpaceService.getOne(psQuery);

                    payFee.setParkingNum(ps.getNum());
                }
                break;

            //合同费
            case "03":
                //没找到费用和合同表的对应关系，先用假数据
                for (PayFee payFee : payFeePage.getRecords()) {
                    payFee.setBusinessName("超级合同");
                }

                break;
        }

        //查询业主名字
        for (PayFee payFee : payFeePage.getRecords()) {
            LambdaQueryWrapper<BuildingOwner> ownerQuery = new LambdaQueryWrapper<>();
            ownerQuery.eq(BuildingOwner::getMemberId, receiptQuery.getMemberId());
            BuildingOwner buildingOwner = buildingOwnerService.getOne(ownerQuery);
            payFee.setOwnerName(buildingOwner.getName());
        }

        //查询费用项目
        for (PayFee payFee : payFeePage.getRecords()) {
            String configId = payFee.getConfigId();
            LambdaQueryWrapper<PayFeeConfig> configQuery = new LambdaQueryWrapper<>();
            configQuery.eq(PayFeeConfig::getConfigId, configId);
            PayFeeConfig payFeeConfig = payFeeConfigService.getOne(configQuery);
            payFee.setFeeName(payFeeConfig.getFeeName());
        }


        return PageVO.create(payFeePage, ReprintReceiptVO.class);
    }

    /**
     * 获取所有费用类型
     * @return 费用类型集合
     */
    @Override
    public List<FeeTypeVO> getTypes() {
        //查询  去重
        QueryWrapper<PayFee> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("DISTINCT fee_type_cd");
        List<PayFee> payFees = baseMapper.selectList(queryWrapper);
        for (PayFee payFee : payFees) {
            if ("01".equals(payFee.getFeeTypeCd())) {
                payFee.setFeeType("房屋费");
            } else if ("02".equals(payFee.getFeeTypeCd())) {
                payFee.setFeeType("车位费");
            } else {
                payFee.setFeeType("合同费");
            }
        }

        //转成VO
        List feeTypes = payFees.stream().map((payFee -> {
            FeeTypeVO feeTypeVO = new FeeTypeVO();
            BeanUtils.copyProperties(payFee, feeTypeVO);
            return feeTypeVO;
        })).collect(Collectors.toList());

        return feeTypes;
    }
}
