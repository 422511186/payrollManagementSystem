package org.project.curriculum.mapper;

import org.apache.ibatis.annotations.*;
import org.project.curriculum.pojo.user;
import org.springframework.stereotype.Repository;

/**
 * 用户类
 *
 * @Auther: hzy
 * @Date: 2022/2/8 18:48
 * @Description:
 */
@Repository
public interface userMapper {

    /**
     * 根据账号查找用户账户信息
     * @param account
     * @return
     */
    @Select(
            value = " select account,password from user where account=#{account}"
    )
    user selectByAccount(@Param("account") String account);

    /**
     * 添加一条用户信息
     * @param user
     * @return
     */
    @Insert(
            value = "insert into user(account, password) values (#{user.account},#{user.password})"
    )
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(@Param("user") user user);

    /**
     * 修改密码
     * @param user
     * @return
     */
    @Update(
            value = "update user set password=#{user.password} where account=#{user.account}"
    )
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int updatePwsByAccount(@Param("user") user user);

}
