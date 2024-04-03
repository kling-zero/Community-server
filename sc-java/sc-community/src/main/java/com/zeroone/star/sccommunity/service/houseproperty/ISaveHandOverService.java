package com.zeroone.star.sccommunity.service.houseproperty;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.dto.community.myCommunity.SavaHandOverDTO;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.sccommunity.entity.houseproperty.SaveHandOver;

public interface ISaveHandOverService extends IService<SaveHandOver> {

    PageVO saveHandOver(SavaHandOverDTO data);
}
