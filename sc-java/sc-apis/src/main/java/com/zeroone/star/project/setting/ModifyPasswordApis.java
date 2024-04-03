package com.zeroone.star.project.setting;

import com.zeroone.star.project.dto.setting.ModifyPasswordDTO;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

/**
 * @author Iris
 * @create 2022-10-15-19:38
 * @email 2015245811@qq.com
 */
public interface ModifyPasswordApis {

    /**
     * 查询条件-修改用户密码
     * @return 修改是否成功
     */
    JsonVO<Integer> modifyUserPassword(ModifyPasswordDTO modifyPasswordDTO);
}
