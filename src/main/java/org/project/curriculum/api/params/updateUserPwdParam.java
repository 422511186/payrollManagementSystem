package org.project.curriculum.api.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: hzy
 * @Date: 2022/2/10 01:06
 * @Description:
 */
@Data
@ApiModel(value = "修改密码参数")
public class updateUserPwdParam {
    @ApiModelProperty(value = "用户账号")
    private String userName;
    @ApiModelProperty(value = "旧密码")
    private String oldPassword;
    @ApiModelProperty(value = "修改的新密码")
    private String newPassword;

}
