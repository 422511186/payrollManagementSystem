package org.project.curriculum.api.Params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: hzy
 * @Date: 2022/2/9 14:40
 * @Description:
 */
@Data
@ApiModel("入职Param")
public class employeeInfoParam {
    @ApiModelProperty("员工姓名")
    private String name;

    @ApiModelProperty("员工职位")
    private String Position;

}
