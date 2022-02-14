package org.project.curriculum.api.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Auther: hzy
 * @Date: 2022/2/13 01:29
 * @Description:
 */
@Data
@ApiModel(value = "考勤VO")
public class AttendanceVO {
    @ApiModelProperty("员工id")
    private Integer id;
    @ApiModelProperty("员工姓名")
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dtime ;

}
