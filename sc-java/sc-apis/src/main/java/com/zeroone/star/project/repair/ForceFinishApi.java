package com.zeroone.star.project.repair;


import com.zeroone.star.project.dto.repair.ForceFinishDTO;
import com.zeroone.star.project.query.repair.demoquery.ForceFinishQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.repair.ForceFinishVO;


//强制回单的Api
public interface ForceFinishApi {
    //查询所有
    JsonVO<PageVO<ForceFinishVO>> queryAll(ForceFinishQuery condition);

    //强制回单
    JsonVO<ForceFinishVO> forceFinish(ForceFinishDTO finishDTO);

    //详情
    JsonVO<ForceFinishVO> detail(ForceFinishDTO finishDTO);
}
