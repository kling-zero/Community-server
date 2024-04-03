package com.zeroone.star.project.test.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 测试EasyExcel用户类
 */
@Data
public class User {
    @ExcelProperty(value = "编号", index = 0)
    private Integer id;

    @ExcelProperty(value = "姓名", index = 1)
    private String name;

    @ExcelProperty(value = "电话", index = 2)
    private String phone;
}
