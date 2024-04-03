package com.zeroone.star.management.mapper;

import com.zeroone.star.project.vo.management.SCommunityVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: Kong
 * @License: (C) Copyright 2005-2019, xxx Corporation Limited.
 * @Contact: xxx@xxx.com
 * @Date: 2022-10-18 10:24
 * @Version: 1.0
 * @Description: 对SCommunityMapper的方法进行测试
 */
@SpringBootTest
public class SCommunityMapperTest {
    @Autowired
    SCommunityMapper mapper;

    @Test
    void testSelectNoEnterCommunity(){
        List<SCommunityVO> sCommunityVOS = mapper.selectNoEnterCommunity();
        System.out.println("testSelectNoEnterCommunity:");
        if (sCommunityVOS.size()==0){
            System.out.println("size 0");
        }else{
            sCommunityVOS.forEach(System.out::println);
        }
    }

}