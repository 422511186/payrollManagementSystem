package org.project.curriculum.api.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: hzy
 * @Date: 2022/2/9 15:35
 * @Description:
 */
@Data
@ApiModel("修改员工资料")
public class modifyParam {

    @ApiModelProperty("员工id")
    private Integer id;

    @ApiModelProperty("员工姓名")
    private String name;

    @ApiModelProperty("员工职位")
    private String Position;

}
