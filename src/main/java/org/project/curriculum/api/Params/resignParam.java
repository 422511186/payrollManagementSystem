package org.project.curriculum.api.Params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: hzy
 * @Date: 2022/2/9 15:17
 * @Description:
 */
@ApiModel("离职Param")
@Data
public class resignParam {
    @ApiModelProperty("员工id")
    private Integer id;
    @ApiModelProperty("员工姓名")
    private String name;
}
