package com.zeroone.star.sccommunity.service.prrmanagement;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.dto.community.propertyrightregistration.CheckDTO;
import com.zeroone.star.project.vo.community.propertyrightregistration.CheckVO;
import com.zeroone.star.sccommunity.entity.prrmanagement.Check;


public interface ICheckService extends IService<Check> {
    CheckVO checkDTO(CheckDTO condition);
}
