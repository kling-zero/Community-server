package com.zeroone.star.sccommunity.service.structure;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroone.star.project.query.community.structure.carStructure.CarStructureQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.structure.carStructure.CarStructureVO;
import com.zeroone.star.sccommunity.entity.structure.CarStructure;

public interface StrIStructureService extends IService<CarStructure> {

    PageVO<CarStructureVO> listAll(CarStructureQuery condition);
}
