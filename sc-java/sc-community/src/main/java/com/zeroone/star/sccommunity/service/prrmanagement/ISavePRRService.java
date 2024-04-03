package com.zeroone.star.sccommunity.service.prrmanagement;

import com.baomidou.mybatisplus.extension.service.IService;

import com.zeroone.star.project.dto.community.propertyrightregistration.SavePRRDTO;
import com.zeroone.star.sccommunity.entity.prrmanagement.SavePRR;


public interface ISavePRRService extends IService<SavePRR> {
    boolean save(SavePRRDTO condition);
}
