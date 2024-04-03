package com.zeroone.star.project.repair;


import com.zeroone.star.project.query.sample.SampleQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.sample.SampleVO;

/**
 * @Description 测试API接口定义
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
public interface SampleApis {
    /**
     * 测试分页查询
     *
     * @param condition 查询条件
     * @return 查询结果
     */
    JsonVO<PageVO<SampleVO>> queryAll(SampleQuery condition);

    /**
     * 通过编号查询数据
     *
     * @param id 编号
     * @return 查询结果
     */
    JsonVO<SampleVO> queryById(int id);
}
