package com.zeroone.star.scmenu.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.menu.FirstMenuDTO;
import com.zeroone.star.project.dto.menu.MenugroupDTO;
import com.zeroone.star.project.dto.menu.SecondaryMenuDTO;
import com.zeroone.star.project.dto.menu.ThirdMenuDTO;
import com.zeroone.star.project.query.menu.FirstMenuPageQuery;
import com.zeroone.star.project.query.menu.MenugroupQuery;
import com.zeroone.star.project.query.menu.SecondaryMenuQuery;
import com.zeroone.star.project.query.menu.ThirdMenuPageQuery;
import com.zeroone.star.project.vo.PageVO;
import com.zeroone.star.project.vo.menu.MenugroupVO;
import com.zeroone.star.project.vo.menu.SecondaryMenuVO;
import com.zeroone.star.project.vo.menu.ThirdMenuVO;
import com.zeroone.star.scmenu.entity.Menu;
import com.zeroone.star.scmenu.entity.Role;
import com.zeroone.star.scmenu.entity.RoleMenu;
import com.zeroone.star.scmenu.mapper.MenuMapper;
import com.zeroone.star.scmenu.mapper.RoleMenuMapper;
import com.zeroone.star.scmenu.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.scmenu.service.IRoleMenuService;
import com.zeroone.star.scmenu.service.IRoleService;
import com.zeroone.star.scmenu.utils.RedisUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author suosuozi
 * @since 2022-10-21
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private IMenuService iMenuService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IRoleMenuService roleMenuService;
    @Autowired
    MenuMapper menuMapper;

    @Autowired
    RoleMenuMapper roleMenuMapper;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public PageVO<ThirdMenuVO> listThirdMenu(ThirdMenuPageQuery thirdMenuPageQuery) {
        Page<Menu> menuPage = new Page<>(thirdMenuPageQuery.getPageIndex(), thirdMenuPageQuery.getPageSize());

        Page<ThirdMenuVO> ThirdMenuVOPage = menuMapper.selectThirdMenu(thirdMenuPageQuery, menuPage);

        return PageVO.create(ThirdMenuVOPage, ThirdMenuVO.class);
    }

    @Override
    public ThirdMenuDTO getAThirdMenu(Integer id, Integer parentMenuId) {
        if(id==null || menuMapper.selectExistMenuById(id)==0){
            log.error("找不到id");
            return null;
        }
        else if(parentMenuId==null || menuMapper.selectExistMenuByParentId(parentMenuId)==0){
            log.error("找不到parentId");
            return null;
        }
        return menuMapper.selectAThirdMenu(id, parentMenuId);
    }

    @Override
    public int saveAThirdMenu(ThirdMenuDTO thirdMenuDTO) {
        Menu menu = new Menu();

        //权限必须绑定一个父级菜单id
        if(thirdMenuDTO.getParentMenuId() == null){
            log.error("未填入二级菜单id");
            return 0;
        }
        else {
            //格式正确，查询有无这个Id
            Integer existMenu = 0;
            existMenu = menuMapper.selectExistMenuByParentId(thirdMenuDTO.getParentMenuId());
            if(existMenu==0){
                log.error("没有这个父级菜单id");
                return 0;
            }
        }
        menu.setParentMenuId(thirdMenuDTO.getParentMenuId());

        //必插
        if(thirdMenuDTO.getName()==null || "".equals(thirdMenuDTO.getName().trim())){
            log.error("未填入名称");
            return 0;
        }
        menu.setName(thirdMenuDTO.getName());

        if(thirdMenuDTO.getLinkUrl()==null || "".equals(thirdMenuDTO.getLinkUrl().trim())){
            log.error("未填入链接地址");
            return 0;
        }
        menu.setLinkUrl(thirdMenuDTO.getLinkUrl());

        //检查roleName
        Integer roleId = null;
        if(thirdMenuDTO.getRoleName()==null || "".equals(thirdMenuDTO.getRoleName().trim())){
            log.error("未填入管理员名称");
            return 0;
        }
        else{
            //判断是否存在
            roleId = roleMenuMapper.selectRoleIdByRoleName(thirdMenuDTO.getRoleName());
            if(roleId==null){
                log.error("没有这个管理员");
                return 0;
            }
        }

        //选插
        if(thirdMenuDTO.getDescription() != null){
            //只有值不为null，才能调用getDescription方法，否则就是空指针异常
            if(!"".equals(thirdMenuDTO.getDescription().trim())){
                menu.setDescription(thirdMenuDTO.getDescription());
            }
        }

        //自动插入数据
        menu.setLevel(3);
        menu.setIsEnable(1);
        menu.setCreateTime(LocalDateTime.now());

        menuMapper.insert(menu);
        return menu.getId();
    }

    @Override
    public int updateThirdMenu(ThirdMenuDTO thirdMenuDTO) {
        //parentMenuId
        if(thirdMenuDTO.getParentMenuId() == null){
            log.error("未填入二级菜单id");
            return 0;
        }
        else {
            //格式正确，查询有无这个Id
            Integer existMenu = 0;
            existMenu = menuMapper.selectExistMenuByParentId(thirdMenuDTO.getParentMenuId());
            if(existMenu==0){
                log.error("没有这个父级菜单id");
                return 0;
            }
        }
        //id
        if(thirdMenuDTO.getId() == null){
            log.error("未填入id");
            return 0;
        }
        else{
            Integer existId = 0;
            existId = menuMapper.selectExistMenuById(thirdMenuDTO.getId());
            if(existId==0){
                log.error("没有这个id");
                return 0;
            }
        }

        //必填项：名字、链接地址、管理员不能为空
        if(thirdMenuDTO.getName()==null || "".equals(thirdMenuDTO.getName().trim())){
            log.error("名称不能为空");
            return 0;
        }
        if(thirdMenuDTO.getLinkUrl()==null || "".equals(thirdMenuDTO.getLinkUrl().trim())){
            log.error("链接地址不能为空");
            return 0;
        }
        Integer roleId = null;
        if(thirdMenuDTO.getRoleName()==null || "".equals(thirdMenuDTO.getRoleName().trim())){
            log.error("未填入管理员名称");
            return 0;
        }
        else{
            //判断是否存在
            roleId = roleMenuMapper.selectRoleIdByRoleName(thirdMenuDTO.getRoleName());
            if(roleId==null){
                log.error("没有这个管理员");
                return 0;
            }
        }

        //选填的description在mapper层有判断

        return menuMapper.updateThirdMenu(thirdMenuDTO);
    }

    @Override
    public Integer removeThirdMenuById(Integer menuId) {
        return menuMapper.deleteThirdMenuById(menuId);
    }

    @Override
    public Integer getRoleIdByRoleName(String roleName) {
        if(roleName==null){
            log.error("管理员名称不能为空");
            return null;
        }

        Integer result = null;
        result = menuMapper.selectRoleIdByRoleName(roleName);
        if(result==null || result==0){
            log.error("没有这个管理员");
            return null;
        }

        return result;
    }

    @Override
    public PageVO<ThirdMenuVO> pageThirdMenuByParentMenuId(int parentMenuId, Page<ThirdMenuDTO> page) {
        Page<ThirdMenuDTO> thirdMenuDTOPage = menuMapper.selectThirdMenuByParentId(parentMenuId, page);
        return PageVO.create(thirdMenuDTOPage, ThirdMenuVO.class);
    }

    @Override
    public ThirdMenuDTO getThirdMenu(Integer id,Integer roleId) {
        return menuMapper.getThirdMenu(id,roleId);
    }

    @Override
    public Page<FirstMenuDTO> listFirstMenu(FirstMenuPageQuery firstMenuPageQuery) {
        return menuMapper.selectFirstMenu(firstMenuPageQuery, new Page<FirstMenuDTO>(firstMenuPageQuery.getPageIndex(), firstMenuPageQuery.getPageSize()));
    }

    @Override
    public FirstMenuDTO getFirstMenu(Integer id, Integer roleId) {
        return menuMapper.getFirstMenu(id, roleId);
    }
    @Override
    public PageVO<MenugroupVO> listAll(MenugroupQuery query) {
        //构建分页对象
        Page<Menu> page = new Page<>(query.getPageIndex(),query.getPageSize());
        //构建条件对象
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.like("name","%"+query.getName()).like("gId","%"+query.getParentMenuId()).like("icon","%"+query.getIcon());
        //执行分页查询
        Page<Menu> pages = baseMapper.selectPage(page, wrapper);
        return PageVO.create(pages, MenugroupVO.class);
    }

    //修改二级菜单
    @Transactional
    public MenugroupVO updateMenuGroup(MenugroupDTO menugroupDTO, String menuGroupId) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menugroupDTO,menu);
        boolean updateMenu = this.updateById(menu);

        boolean updateRole = true;
        //查看是否需要修改用户组
        //1.获得当前菜单组的所属商户
        RoleMenu roleMenu = roleMenuService.getOneByMenuGroupId(menuGroupId);
        //2.获得商户信息
        Role role = roleService.getById(roleMenu.getRoleId());
        if(! role.getName().equals(menugroupDTO.getRoleName())){
            //重设所属商户的id
            roleMenu.setRoleId(role.getId());
            //修改用户组
            LambdaQueryWrapper<RoleMenu> roleMenuLambdaQueryWrapper = new LambdaQueryWrapper<>();
            roleMenuLambdaQueryWrapper.eq(RoleMenu::getMenuId,roleMenu.getMenuId());
            roleMenuLambdaQueryWrapper.eq(RoleMenu::getRoleId,roleMenu.getRoleId());

            updateRole = roleMenuService.update(roleMenuLambdaQueryWrapper);
        }
        if(!(updateMenu && updateRole)){
            return null;
        }

        MenugroupVO menugroupVO = new MenugroupVO();
        BeanUtils.copyProperties(menu, menugroupVO);
        menugroupVO.setRoleName(role.getName());
        return menugroupVO;
    }

    @Override
    public Boolean removeMenugroup(Integer Id) {
        //查询是否关联了二级菜单
        LambdaQueryWrapper<Menu> menuLambdaQueryWrapper = new LambdaQueryWrapper<>();
        menuLambdaQueryWrapper.eq(Menu::getParentMenuId,Id);
        long count = iMenuService.count(menuLambdaQueryWrapper);

        if (count > 0){
            return false;
        }
        return true;
    }


    @Transactional
    @Override
    public boolean saveMenuGroup(MenugroupDTO menugroupDTO) {
        Menu menu = new Menu();
        //id为自增
        BeanUtils.copyProperties(menugroupDTO,menu);
        menu.setParentMenuId(3);
        //向菜单表新增 新增后，menu的id属性会被自动填充
        boolean addMenu = this.save(menu);

        //向role_menu新增
        //1.获得相关信息
        String roleName = menugroupDTO.getRoleName();
        Role role = roleService.getOneByName(roleName);

        //2.生成实体类
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setMenuId(menu.getId());

        roleMenu.setRoleId(role.getId());
        boolean addRole = roleService.save(role);

        return addMenu && addRole;
    }
    @Override
    public List<SecondaryMenuVO> selectSubmenu(SecondaryMenuQuery query) {
        String reidsKey = "ScondaryMenu:List";

        //从redis获得缓存
        //基于reids完成分页操作
        long start = (query.getPageIndex() - 1) * query.getPageSize();
        long end = start + query.getPageSize();
        //TODO rediskey
        List<SecondaryMenuVO> redisSecondaryMenuVOList = redisUtils.getList(reidsKey, start, end);
        if (redisSecondaryMenuVOList != null && redisSecondaryMenuVOList.size() > 0) {
//            log.info("二级菜单 查询 :从redis获得缓存成功:" + redisSecondaryMenuVOList.toString());
            //条件过滤
            //1.菜单id
            if (!Objects.isNull(query.getId())) {
                Integer id = query.getId();
                redisSecondaryMenuVOList = redisSecondaryMenuVOList.stream().filter(item -> {
                    return item.getId().equals(id);
                }).collect(Collectors.toList());
            }
            //2.菜单名称
            if (!StringUtils.isEmpty(query.getName())) {
                String finalName = query.getName();
                redisSecondaryMenuVOList = redisSecondaryMenuVOList.stream().filter(item -> {
                    return item.getName().equals(finalName);
                }).collect(Collectors.toList());
            }
            //3.父菜单id
            if (!Objects.isNull(query.getParentMenuId())) {
                Integer id = query.getParentMenuId();
                redisSecondaryMenuVOList = redisSecondaryMenuVOList.stream().filter(item -> {
                    return item.getParentMenuId().equals(id);
                }).collect(Collectors.toList());
            }
            //4.父菜单名称
            if (!StringUtils.isEmpty(query.getParentMenuName())) {
                String finalName = query.getParentMenuName();
                redisSecondaryMenuVOList = redisSecondaryMenuVOList.stream().filter(item -> {
                    return item.getParentMenuName().equals(finalName);
                }).collect(Collectors.toList());
            }
            //5.商户
            if (!StringUtils.isEmpty(query.getRoleName())) {
                String finalName = query.getRoleName();
                redisSecondaryMenuVOList = redisSecondaryMenuVOList.stream().filter(item -> {
                    return item.getRoleName().equals(finalName);
                }).collect(Collectors.toList());
            }
            return redisSecondaryMenuVOList;
        }

        //从mysql获得 从视图second_menu查找
        List<SecondaryMenuVO> secondaryMenuVOList = menuMapper.selectSubmenu();
//        log.info(secondaryMenuVOList.toString());
        //分页操作
        List<SecondaryMenuVO> pageResult = secondaryMenuVOList.subList((int) start, (int) Math.min(end, secondaryMenuVOList.size()));
        if(secondaryMenuVOList.size() > 0){
            //TODO rediskey
            boolean list = redisUtils.ListIntoRedisWithTimeLimit(reidsKey, secondaryMenuVOList, 60 * 24 * 3);
//            log.info("二级菜单 查询 :redis添加缓存:" + list);
        }

        return pageResult;
    }

    @Transactional
    @Override
    public boolean saveSubmenu(SecondaryMenuDTO secondaryMenuDTO) {
        String reidsKey = "ScondaryMenu:List";

        //1.向menu添加
        Menu menu = new Menu();
        BeanUtils.copyProperties(secondaryMenuDTO, menu);
        menu.setLevel(2);
        boolean saveMenu = this.save(menu);
        //2.向role_menu表添加
        String roleName = secondaryMenuDTO.getRoleName();
        Role role = roleService.getOneByName(roleName);
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setMenuId(menu.getId());
        roleMenu.setRoleId(role.getId());
        roleMenu.setStatus(1);
        boolean saveRoleMeu = roleMenuService.save(roleMenu);

        //TODO rediskey
        if(saveMenu && saveRoleMeu){
            if(redisUtils.isExist(reidsKey)){
                SecondaryMenuVO secondaryMenuVO = new SecondaryMenuVO();
                BeanUtils.copyProperties(menu, secondaryMenuVO);
                secondaryMenuVO.setRoleName(role.getName());
                secondaryMenuVO.setParentMenuName(secondaryMenuDTO.getParentMenuName());

                //TODO rediskey
                boolean updateRedis = redisUtils.IntoRedisList(reidsKey, secondaryMenuVO);
//                log.info("二级菜单 添加 key:"+ reidsKey +":redis更新缓存:" + updateRedis);
            }
        }

        return saveMenu && saveRoleMeu;
    }

    @Override
    public SecondaryMenuVO updateSubmenu(SecondaryMenuDTO secondaryMenuDTO, Integer secondaryMenuId) {
        Menu menu = new Menu();
        menu.setId(secondaryMenuId);
        BeanUtils.copyProperties(secondaryMenuDTO,menu);
//        log.info(menu.toString());
        boolean Menu = this.updateById(menu);
        if (! Menu){
            return null;
        }
        if(Menu ){
            String reidsKey = "ScondaryMenu:List";
            if(redisUtils.isExist(reidsKey)){
                //TODO rediskey
                boolean updateRedis = redisUtils.deleteKey(reidsKey);
//                log.info("二级菜单 更新 key:"+ reidsKey +":redis删除缓存:" + updateRedis);
            }
        }
        SecondaryMenuVO secondaryMenuVO = new SecondaryMenuVO();
        BeanUtils.copyProperties(menu,secondaryMenuVO);
        return secondaryMenuVO;
    }

    @Transactional
    public boolean deleteSubmenu(Integer Id,  String roleName){
        //1.改变isEnable
//        boolean removeById = this.removeById(Id);
        boolean updateIsEnable = menuMapper.updateIsEnable(Id);

        //2.改变roleMenu
        Role role = roleService.getOneByName(roleName);
        boolean updateRoleMenu = roleMenuMapper.updateStatus(Id, role.getId());

        if(updateIsEnable && updateRoleMenu){
            String reidsKey = "ScondaryMenu:List";
            if(redisUtils.isExist(reidsKey)){
                //TODO rediskey
                boolean removeRedis = redisUtils.deleteKey(reidsKey);
//                log.info("二级菜单 删除 key:"+ reidsKey +":redis删除缓存:" + removeRedis);
            }
        }

        return updateIsEnable && updateRoleMenu;
    }
}
