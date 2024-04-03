package com.zeroone.star.project.dto.community.transactions.ownerMember;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DeleteOwnerMemberDto {
    @ApiModelProperty(value = "成员id",example = "772022081789319011")
    private String memberId;
}
