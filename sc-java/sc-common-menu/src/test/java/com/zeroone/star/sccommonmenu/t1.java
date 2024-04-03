package com.zeroone.star.sccommonmenu;

import com.zeroone.star.project.vo.JsonVO;
import com.zeroone.star.project.vo.commonMenu.TreeMenuVO;
import com.zeroone.star.sccommonmenu.controller.MenuController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = com.zeroone.star.sccommonmenu.controller.MenuController.class)
public class t1 {

    @Autowired(required = true)
    private MenuController menuController;

    @Test
    public void p(){
        JsonVO<List<TreeMenuVO>> listJsonVO = menuController.menuList();
        System.out.println(listJsonVO);
    }
}
