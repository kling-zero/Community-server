package com.zeroone.star.project.roleprivilege;

import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.roleprivilege.PPrivilegeGroupVO;

import java.util.List;

public interface RolePrivilegeGroupApis {

    /**
     * 查询权限组
     * @return
     */
    JsonVO<List<PPrivilegeGroupVO>> listPrivilegeGroup(String storeId);

    /**
     * 查询权限
     * @return
     */
    JsonVO<String> loadListPrivilege(String pgId);

    /**
     * 保存权限组
     * @return
     */
    JsonVO<String> savePrivilegeGroup(String storeId);

    /**
     * 编辑权限组
     * @return
     */
    JsonVO<String> editPrivilegeGroup(String sotreId);

    /**
     * 删除权限组
     * @return
     */
    JsonVO<String> deletePrivilegeGroup(String storeId);
}
