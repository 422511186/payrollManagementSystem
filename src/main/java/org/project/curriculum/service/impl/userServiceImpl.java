package org.project.curriculum.service.impl;

import org.project.curriculum.api.Params.updateUserPwdParam;
import org.project.curriculum.exception.FailException;
import org.project.curriculum.exception.LoginException;
import org.project.curriculum.mapper.userMapper;
import org.project.curriculum.pojo.user;
import org.project.curriculum.service.userService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * 用户账号相关业务
 *
 * @Auther: hzy
 * @Date: 2022/2/8 23:35
 * @Description:
 */
@Service
@Transactional(rollbackFor = {FailException.class, SQLException.class,LoginException.class})
public class userServiceImpl implements userService {
    private final userMapper userMapper;

    public userServiceImpl(userMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 注册
     * @param user
     * @return
     * @throws FailException
     */
    @Override
    public boolean Register(user user) throws FailException {
        user user1 = userMapper.selectByAccount(user.getAccount());
        if (null!=user1)
            throw new FailException("该用户名已存在。");
        int insert = userMapper.insert(user);
        if (0==insert)
            throw new FailException("未知异常。");
        return true;
    }

    /**
     * 登录
     * @param user
     * @return
     * @throws FailException
     * @throws LoginException
     */
    @Override
    public boolean Login(user user) throws  LoginException {
        user user1 = userMapper.selectByAccount(user.getAccount());

        if (null==user1|| !user1.getPassword().equals(user.getPassword()))
            throw new LoginException("账号或密码错误");
        return true;
    }

    /**
     * 修改密码
     * @param param
     * @return
     * @throws LoginException
     * @throws FailException
     * @throws SQLException
     */
    @Override
    public boolean updatePwd(updateUserPwdParam param) throws LoginException, FailException {
        //获取数据库中该用户信息
        user user1 = userMapper.selectByAccount(param.getUserName());
        if (null==user1)//为空时，说明不存在
            throw new LoginException("该用户不存在");
        if (!user1.getPassword().equals(param.getOldPassword()))
            throw new LoginException("旧密码错误");
        if(user1.getPassword().equals(param.getOldPassword())){//当传进来的旧密码与数据库中的密码相同时
            int i = userMapper.updatePwsByAccount(
                    new user(0, param.getUserName(), param.getNewPassword()));
            if (i==0)
                throw new FailException("密码更新失败");
        }
        return true;
    }
}
