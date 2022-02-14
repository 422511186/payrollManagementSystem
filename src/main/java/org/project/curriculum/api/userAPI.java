package org.project.curriculum.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.project.curriculum.api.Params.updateUserPwdParam;
import org.project.curriculum.api.Params.userParam;
import org.project.curriculum.exception.FailException;
import org.project.curriculum.exception.LoginException;
import org.project.curriculum.exception.ParamException;
import org.project.curriculum.pojo.user;
import org.project.curriculum.service.impl.userServiceImpl;
import org.project.curriculum.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Auther: hzy
 * @Date: 2022/2/10 01:57
 * @Description:
 */
@RestController
@Api(tags = "用户相关接口")
@RequestMapping(value = "/api/user")
public class userAPI {

    private final userServiceImpl userService;

    public userAPI(userServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    @ApiOperation(value = "登录接口")
    Result<String> Login(@RequestBody userParam userParam, HttpSession session) throws LoginException, ParamException {

        if (userParam.getAccount().isEmpty()||userParam.getPassword().isEmpty())
            throw new ParamException("参数缺失");

        boolean result = userService.Login(new user(0, userParam.getAccount(), userParam.getPassword()));
        if (result){
            session.setAttribute("loginUser",userParam);
            return new Result<>(200, "SUCCESS","登录成功");
        }
        else
            return new Result<>(403, "FAIL","登录失败");
    }

    @GetMapping(value = "/logout")
    @ApiOperation(value = "退出登录接口")
    Result<String> logout( HttpSession session) throws LoginException, ParamException {
        Object user = session.getAttribute("loginUser");
        if (user!=null){
            session.removeAttribute("loginUser");
            return new Result<>(200, "SUCCESS","退出登录成功");
        }
        return new Result<>(403, "FAIL","当前已不在线");
    }

    @PostMapping(value = "/Register")
    @ApiOperation(value = "注册接口")
    Result<String> Register(@RequestBody userParam userParam) throws LoginException, FailException, ParamException {

        if (userParam.getAccount().isEmpty()||userParam.getPassword().isEmpty())
            throw new ParamException("参数缺失");

        boolean result = userService.Register(new user(0, userParam.getAccount(), userParam.getPassword()));
        if (result)
            return new Result<>(200, "SUCCESS","注册成功");
        else
            return new Result<>(419, "FAIL","注册失败");
    }

    @PostMapping(value = "/updatePwd")
    @ApiOperation(value = "修改密码接口")
    Result<String> updatePwd(@RequestBody updateUserPwdParam userParam) throws LoginException, FailException, ParamException {
        if (userParam.getUserName().isEmpty() ||userParam.getOldPassword().isEmpty() || userParam.getNewPassword().isEmpty())
            throw new ParamException("参数缺失");

        boolean result = userService.updatePwd(userParam);
        if (result)
            return new Result<>(200, "SUCCESS","修改成功");
        else
            return new Result<>(419, "FAIL","修改失败");
    }


}
