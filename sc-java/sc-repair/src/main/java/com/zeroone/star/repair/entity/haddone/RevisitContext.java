package com.zeroone.star.repair.entity.haddone;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("r_repair_return_visit")
public class RevisitContext {

    //回访满意度，需要将类型值转换为类型名
    private String visitType;
    //回访内容
    private String context;
}
