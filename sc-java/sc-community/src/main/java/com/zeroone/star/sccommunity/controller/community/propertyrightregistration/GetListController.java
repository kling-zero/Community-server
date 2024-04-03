package com.zeroone.star.sccommunity.controller.community.propertyrightregistration;

import com.zeroone.star.project.community.propertyrightregistration.FloorListApi;
import com.zeroone.star.project.community.propertyrightregistration.StateListApi;
import com.zeroone.star.project.vo.community.propertyrightregistration.FloorVO;
import com.zeroone.star.project.vo.community.propertyrightregistration.StateVO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("propertyRightRegistration")
@Api(tags = "显示下拉列表")
public class GetListController implements StateListApi, FloorListApi {
    /**
     * 设计模式-懒汉式-审核列表
     */
    private static List<StateVO> listState;
    public static List<StateVO> getStateInstance(){
        if (listState==null){
            synchronized (List.class){//防止多线程
                if (listState==null){
                    listState = new ArrayList<>();
                    listState.add(new StateVO("未审核"));
                    listState.add(new StateVO("审核通过"));
                    listState.add(new StateVO("审核不通过"));
                }
            }
        }
        return listState;
    }

    /**
     * 未审核、审核通过、审核不通过
     * @return
     */
    @Override
    public List<StateVO> getStateList() {
        return getStateInstance();
    }


    /**
     * 设计模式-懒汉式-楼层列表
     */
    private  static List<FloorVO> listFloor;
    public static List<FloorVO> getFloorInstance(){
        if (listFloor==null){
            synchronized (List.class){//防止多线程
                if (listFloor==null){
                    listFloor = new ArrayList<>();
                    listFloor.add(new FloorVO("1号楼"));
                    listFloor.add(new FloorVO("2号楼"));
                    listFloor.add(new FloorVO("9号楼"));
                    listFloor.add(new FloorVO("10号楼"));
                    listFloor.add(new FloorVO("30号楼"));
                }
            }
        }
        return listFloor;
    }

    /**
     * 1号楼
     * 2号楼
     * 9号楼
     * 10号楼
     * 30号楼
     * @return
     */
    @Override
    public List<FloorVO> getFloorList() {
        return getFloorInstance();
    }
}
