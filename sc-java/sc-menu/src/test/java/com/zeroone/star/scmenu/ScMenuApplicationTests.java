package com.zeroone.star.scmenu;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.project.dto.menu.FirstMenuDTO;
import com.zeroone.star.project.dto.menu.ThirdMenuDTO;
import com.zeroone.star.project.query.menu.FirstMenuPageQuery;
import com.zeroone.star.project.query.menu.ThirdMenuPageQuery;
import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.scmenu.entity.Menu;
import com.zeroone.star.scmenu.mapper.MenuMapper;
import com.zeroone.star.scmenu.mapper.RoleMenuMapper;
import com.zeroone.star.scmenu.service.IMenuService;
import com.zeroone.star.scmenu.service.IRoleMenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScMenuApplicationTests {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    RoleMenuMapper roleMenuMapper;

    @Autowired
    IMenuService iMenuService;

    @Autowired
    IRoleMenuService roleMenuService;

    @Test
    void contextLoads() {
    }

    @Test
    void testDelete(){
        Integer menuId = 26;

        Integer result = null;
        System.out.println(result);

        result = menuMapper.deleteThirdMenuById(menuId);
        System.out.println(result);
    }

    @Test
    void testInsert(){
        ThirdMenuDTO thirdMenuDTO = new ThirdMenuDTO();
        thirdMenuDTO.setParentMenuId(-106);

        Integer existMenu = 0;
        //权限必须绑定一个父级菜单id
        if(thirdMenuDTO.getParentMenuId() == null){
            System.out.println("未填入正确的二级菜单id");
            return;
        }
        else {
            //格式正确，查询有无这个Id
            try {
                existMenu = menuMapper.selectExistMenuByParentId(thirdMenuDTO.getParentMenuId());
            } catch (NullPointerException e) {
                System.out.println("没有这个父级菜单id");
                return;
            }
        }
        System.out.printf("查询菜单成功existMenu总数=%d\n", existMenu);
    }

    @Test
    void testQueryAMenu(){
        Integer id = 10;
        Integer parentMenuId = 16;

        int success = -1;
        ThirdMenuDTO thirdMenuDTO = menuMapper.selectAThirdMenu(id, parentMenuId);
        System.out.println(thirdMenuDTO);
    }

    @Test
    void testInsertRoleAndMenu(){
        ThirdMenuDTO thirdMenuDTO = new ThirdMenuDTO();
        thirdMenuDTO.setRoleName("?sgsgg");

        Integer roleId = null;
        //通过roleName获取role表的id
        if(thirdMenuDTO.getRoleName()==null || "".equals(thirdMenuDTO.getRoleName().trim())){
            System.out.println("未填入管理员名称");
            return;
        }
        else{
            roleId = roleMenuMapper.selectRoleIdByRoleName(thirdMenuDTO.getRoleName());
            if(roleId==null){
                System.out.println("没有这个管理员");
                return;
            }
//            try {
//                roleId = roleMenuMapper.selectRoleIdByRoleName(thirdMenuDTO.getRoleName());
//            } catch (NullPointerException e) {
//                System.out.println("没有这个管理员");
//                return;
//            }
        }

        System.out.println("roleId="+roleId);
        System.out.println("有这个管理员："+thirdMenuDTO.getRoleName());
    }

    @Test
    void testUpdate(){
        ThirdMenuDTO thirdMenuDTO = new ThirdMenuDTO();
        thirdMenuDTO.setParentMenuId(99);  //problem
        thirdMenuDTO.setId(39);

        thirdMenuDTO.setName("aaaa");
        thirdMenuDTO.setLinkUrl("/aaaaa");
        thirdMenuDTO.setRoleName("超级管理员");
        thirdMenuDTO.setDescription("aaaaa");

        int menuUpdate = 0;
        System.out.println(menuUpdate);

        menuUpdate = iMenuService.updateThirdMenu(thirdMenuDTO);
        if(menuUpdate==0) System.out.println("修改菜单信息失败");
        else System.out.println("菜单信息修改成功");
        System.out.println(menuUpdate);

        //修改role_menu表数据
        int roleMenuUpdate = 0;
        System.out.println(roleMenuUpdate);

        roleMenuUpdate = roleMenuService.updateRoleMenu(thirdMenuDTO);
        if(roleMenuUpdate==0) System.out.println("修改菜单信息对应的管理员失败");
        else System.out.println("菜单信息对应角色修改成功");

        System.out.println("修改菜单成功");
    }
}



