package com.zeroone.star.project.community.transactions.OwnerContract;

import com.zeroone.star.project.dto.community.transactions.ownerContract.*;
import com.zeroone.star.project.query.PageQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.community.transactions.ownerContract.*;

public interface OwnerContractApis {

    /**
     * 通过合同对象查查询合同
     *
     * @param contation contation
     * @return {@code JsonVO<PageVO<OwnerContractVO>>}
     */
    JsonVO<PageVO<OwnerContractVO>> queryContractByObj(OwnerContractByObjDTO contation);

    /**
     * 合同查询
     *
     * @param contation contation
     * @return {@code JsonVO<PageVO<OwnerContractVO>>}
     */
    JsonVO<PageVO<OwnerContractVO>> queryContract(OwnerContractDTO contation);

    /**
     * 查询合同列表详情
     *
     * @param contation contation
     * @return {@code JsonVO<OwnerContractVO>}
     */
    JsonVO<OwnerContractVO> queryContractList(OwnerContractDTO contation);

    /**
     * 查询合同文件
     *
     * @param contation contation
     * @return {@code JsonVO<OwnerContractVO>}
     */
    JsonVO<OwnerContractVO> queryContractFile(QueryContractFileDTO contation);

    /**
     * 更新合同内容
     *
     * @param contation contation
     * @return {@code JsonVO<OwnerContractVO>}
     */
    JsonVO<OwnerContractVO> updateContract(UpdateContractDTO contation);

    /**
     * 删除合同
     *
     * @param contation contation
     * @return {@code JsonVO<String>}
     */
    JsonVO<String> deleteContract(OwnerContractDTO contation);

    /**
     * 查询合同类型
     *
     * @param contation contation
     * @return {@code JsonVO<PageVO<ContraTypeVO>>}
     */
    JsonVO<PageVO<ContraTypeVO>> queryContractType(PageQuery contation);

    /**
     * 查询甲方合同
     *
     * @param contation contation
     * @return {@code JsonVO<PageVO<ContractPartyaVO>>}
     */
    JsonVO<PageVO<ContractPartyaVO>> queryContractPartya(PageQuery contation);

    /**
     * 添加合同
     *
     * @param contation contation
     * @return {@code JsonVO<String>}
     */
    JsonVO<String> saveContract(SaveContractDTO contation);

    /**
     * 打印合同
     *
     * @param contation contation
     * @return {@code JsonVO<PageVO<PrintContractVO>>}
     */
    JsonVO<PageVO<PrintContractVO>> printContract(PrintContractDTO contation);

    /**
     * 查询合同房间
     *
     * @param contation contation
     * @return {@code JsonVO<PageVO<QueryContractDetailVO>>}
     */
    JsonVO<PageVO<QueryContractDetailVO>> queryContractRoom(OwnerContractDTO contation);
}
