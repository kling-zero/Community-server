package com.zeroone.star.project.components.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 表格读取监听器
 * @Author 阿伟学长
 * @Copy &copy;01星球
 * @Address 01星球总部
 */
public class ExcelReadListener<T> implements ReadListener<T> {
    @Getter
    private final List<T> dataList = new ArrayList<>();

    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        dataList.add(t);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("读取完成");
    }
}
