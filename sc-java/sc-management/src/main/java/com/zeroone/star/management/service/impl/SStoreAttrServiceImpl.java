package com.zeroone.star.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zeroone.star.management.entity.SStoreAttr;
import com.zeroone.star.management.entity.Spec;
import com.zeroone.star.management.mapper.SStoreAttrMapper;
import com.zeroone.star.management.service.ISStoreAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nmh
 * @since 2022-10-17
 */
@Service
public class SStoreAttrServiceImpl extends ServiceImpl<SStoreAttrMapper, SStoreAttr> implements ISStoreAttrService {

    @Autowired
    SStoreAttrMapper sStoreAttrMapper;
    @Override
    public int insertSStoreAttr(Spec spec,String corporation,String storeID) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        String gcID;
        String attrID;
        String time = String.valueOf(System.currentTimeMillis());
        time = String.valueOf(System.currentTimeMillis());
        time = time.substring(time.length() - 8);
        attrID = "11" + simpleDateFormat2.format(date) +  time;
        SStoreAttr sStoreAttr = new SStoreAttr();
        sStoreAttr.setStoreId(storeID);
        sStoreAttr.setAttrId(attrID);
        sStoreAttr.setStatusCd(spec.getSpecCd());
        sStoreAttr.setValue(corporation);
        sStoreAttr.setCreateTime(LocalDateTime.now());
        sStoreAttr.setStatusCd("0");
        sStoreAttr.setSpecCd("100201903001");
        return sStoreAttrMapper.insert(sStoreAttr);
    }

    @Override
    public int updateSStroeAttrValueById(String id,String value) {
        UpdateWrapper<SStoreAttr> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("value",value).eq("store_id",id);
        return sStoreAttrMapper.update(null,updateWrapper);
    }
}
