package org.project.curriculum.api.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: hzy
 * @Date: 2022/2/8 13:49
 * @Description:
 */
@Data
@ApiModel(value = "用户账号信息类")
public class userParam {
    @ApiModelProperty(value = "账号")
    private String account;
    @ApiModelProperty(value = "密码")
    private String password;


}
