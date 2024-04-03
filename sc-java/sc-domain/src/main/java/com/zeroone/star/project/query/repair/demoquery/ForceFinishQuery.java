package com.zeroone.star.project.query.repair.demoquery;

import com.zeroone.star.project.query.repair.FatherQuery;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("强制回单查询")
public class ForceFinishQuery extends FatherQuery {
}
