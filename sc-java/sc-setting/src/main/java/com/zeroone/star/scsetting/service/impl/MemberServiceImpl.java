package com.zeroone.star.scsetting.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.setting.MemberInfoDto;
import com.zeroone.star.project.query.setting.MemberQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.setting.MemberFullInfoVo;
import com.zeroone.star.project.vo.setting.MemberSimpleInfoVo;
import com.zeroone.star.scsetting.entity.OrganizationalInformation;
import com.zeroone.star.scsetting.entity.User;
import com.zeroone.star.scsetting.mapper.OrganizationalInformationMapper;
import com.zeroone.star.scsetting.mapper.UserMapper;
import com.zeroone.star.scsetting.service.MemberService;
import io.seata.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @BelongsProject: zero-one-smart-community
 * @BelongsPackage: com.zeroone.star.scsetting.service.Impl
 * @Author: sensfloron
 * @CreateTime: 2022-10-17  10:10
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private OrganizationalInformationMapper organizationalInformationMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageVO<MemberSimpleInfoVo> getInfoList(MemberQuery query) {
        // 分页查询MemberSimpleInfoVo

        // 分页对象
        Page<OrganizationalInformation> page = new Page<>(query.getPageIndex(), query.getPageSize());

        //条件对象
        QueryWrapper<OrganizationalInformation> wrapper = new QueryWrapper<>();

        //查询条件
        wrapper
                .like(StringUtils.isNotBlank(query.getName()), "name", "%" + query.getName() + "%")
                .like(StringUtils.isNotBlank(query.getTel()), "tel", "%" + query.getTel() + "%")
                .eq(query.getId() != null, "id", query.getId());

        //执行分页查询
        Page<OrganizationalInformation> result = organizationalInformationMapper.selectPage(page, wrapper);

        return PageVO.create(result, MemberSimpleInfoVo.class);
    }

    @Override
    public MemberFullInfoVo getMemberFullInfo(Long id) {
        // TODO 根据员工ID查询完整的员工关联信息
        return null;
    }

    @Override
    public void addMemberInfo(MemberInfoDto memberInfoDto) throws Exception {
        // 判断手机号是否已经存在，存在则跑出指定异常信息

        Boolean flag = 1 == organizationalInformationMapper.isExistTel(memberInfoDto.getTel());

        //手机号已存在 抛出异常
        if (flag) {
            throw new Exception("手机号已存在");
        }

        //表business_user
        //将日期作为id前缀加三位随机数
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Integer random = (new Random().nextInt(89999999)) + 10000000;
        String date = simpleDateFormat.format(new Date()) + random;
        OrganizationalInformation organizationalInformation = new OrganizationalInformation();

        //id
        Integer id = Integer.parseInt(date);
        organizationalInformation.setId(id);

        //b_id
        String bId = "20" + date + random;
        organizationalInformation.setBId(bId);

        //user_id
        String userId = "30" + date + random;
        organizationalInformation.setUserId(userId);

        organizationalInformation.setName(memberInfoDto.getName());
        organizationalInformation.setTel(memberInfoDto.getTel());
        organizationalInformation.setSex(memberInfoDto.getSex());
        //邮箱
        organizationalInformation.setEmail(memberInfoDto.getPhoneNum());
        organizationalInformation.setAddress(memberInfoDto.getAddress());
        organizationalInformation.setOperate("ADD");

        int organizationalFlag = organizationalInformationMapper.insert(organizationalInformation);

        //表u_user
        User user = new User();

        user.setUserId(userId);
        user.setName(memberInfoDto.getName());
        user.setEmail(memberInfoDto.getPhoneNum());
        user.setAddress(memberInfoDto.getAddress());
        user.setSex(memberInfoDto.getSex());
        user.setTel(memberInfoDto.getTel());
        user.setBId(bId);
        user.setStatusCd("0");

        int userFlag = userMapper.insert(user);

        if (organizationalFlag != 1 && userFlag != 1) {
            throw new Exception("插入失败 出现异常");
        }
    }

    @Override
    public void deleteMemberInfo(Long id) {
        // TODO 根据员工编号ID删除员工信息
    }

    @Override
    public String resetPassword(Long id) throws Exception {
        // 根据员工编号ID密码重置为生成随机六位数密码，并返回给前端

        int num = new Random().nextInt(9);

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < 6; i++) {
            stringBuffer.append(num);
        }

        String password = stringBuffer.toString();

        String passwordMd5 = "";

        try {
            passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean flagU = false, flagB = false;

        flagU = 1 == userMapper.updateById(id, passwordMd5);
        flagB = 1 == organizationalInformationMapper.updateById(id, passwordMd5);


        if (flagB && flagU) {
            return password;
        }

        throw new Exception("修改密码异常");
    }
}
