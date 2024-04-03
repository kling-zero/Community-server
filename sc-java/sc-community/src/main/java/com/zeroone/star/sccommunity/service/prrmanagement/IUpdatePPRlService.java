package com.zeroone.star.sccommunity.service.prrmanagement;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.dto.community.propertyrightregistration.UpdatePPRlDTO;

import com.zeroone.star.sccommunity.entity.prrmanagement.UpdatePPRl;
import org.springframework.stereotype.Repository;


public interface IUpdatePPRlService extends IService<UpdatePPRl> {

    void updatePRRl(UpdatePPRlDTO condition);

}
