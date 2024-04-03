package com.zeroone.star.scsetting.service;

import com.zeroone.star.project.dto.setting.PersonnelDto;
import com.zeroone.star.project.query.setting.PersonnelQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.setting.PersonnelVO;
import com.zeroone.star.scsetting.entity.Personnel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author insist
 * @since 2022-10-15
 */
public interface PersonnelService extends IService<Personnel> {

    PageVO<PersonnelVO> queryPersonnelByName(List<String> staffIds, PersonnelQuery personnelQuery);

    List<PersonnelVO> queryNotAssociatedPersonnelByName(List<String> staffIds, String name);

    PersonnelDto selectPersonnelById(String PersonnelId);
}
