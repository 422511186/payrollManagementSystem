package org.project.curriculum.api.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Auther: hzy
 * @Date: 2022/2/8 23:45
 * @Description:
 */
@Data
@ApiModel("返回前端展示员工信息类")
public class employeeInfoVO {

    @ApiModelProperty("员工id")
    private Integer id;

    @ApiModelProperty("员工姓名")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("员工入职时间")
    private Date entryTime;

    @ApiModelProperty("员工职位")
    private String Position;

    @ApiModelProperty("员工薪水")
    private Double salary;


}
