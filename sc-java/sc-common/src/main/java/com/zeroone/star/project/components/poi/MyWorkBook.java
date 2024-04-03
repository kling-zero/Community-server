package com.zeroone.star.project.components.poi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @Description 自定义WorkBook
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
@AllArgsConstructor
@Getter
@ToString
public class MyWorkBook {
    /**
     * 是否是新建的空工作薄
     */
    private boolean isNull;

    /**
     * 关联一个工作薄对象
     */
    private Workbook workbook;
}
