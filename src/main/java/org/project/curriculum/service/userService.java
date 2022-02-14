package org.project.curriculum.service;

import org.project.curriculum.api.Params.updateUserPwdParam;
import org.project.curriculum.exception.FailException;
import org.project.curriculum.exception.LoginException;
import org.project.curriculum.pojo.user;

import java.sql.SQLException;

/**
 * @Auther: hzy
 * @Date: 2022/2/8 23:34
 * @Description:
 */
public interface userService {

    /**
     * 注册
     * @param user
     * @return
     * @throws FailException
     */
    boolean Register(user user) throws FailException;

    /**
     * 登录
     * @param user
     * @return
     * @throws FailException
     * @throws LoginException
     */
    boolean Login(user user) throws FailException, LoginException;

    /**
     * 修改密码
     * @param param
     * @return
     * @throws LoginException
     * @throws FailException
     * @throws SQLException
     */
    boolean updatePwd(updateUserPwdParam param) throws LoginException, FailException, SQLException;
}
