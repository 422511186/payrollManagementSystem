package org.project.curriculum.service;

import org.project.curriculum.exception.FailException;
import org.project.curriculum.pojo.salarySetting;

import java.util.List;

/**
 * 企业基本工资报表相关业务
 *
 * @Auther: hzy
 * @Date: 2022/2/8 18:04
 * @Description:
 */

public interface basicSalaryService {

    /**
     * 初始化企业工资(批量插入操作)
     *
     * @param list
     * @return
     */
    int InitBasicSalary(List<salarySetting> list) throws FailException;

    /**
     * 添加一条信息
     *
     * @param value
     * @return
     */
    int addOneItem(salarySetting value) throws FailException;

    /**
     * 批量更新‘职称’相对应的基本工资
     *
     * @param list
     * @return
     */
    int updateBasicSalary(List<salarySetting> list) throws FailException;

    /**
     * 单个更新’职称‘相对应的基本工资
     *
     * @param value
     * @return
     */
    int updateBasicSalary(salarySetting value) throws FailException;

    /**
     * 删除单条
     *
     * @param value
     * @return
     */
    int deleteByObj(salarySetting value) throws FailException;

    /**
     * 删除多条
     *
     * @param list
     * @return
     */
    int deleteByObj(List<salarySetting> list) throws FailException;

    /**
     * 获取企业基本工资列表
     *
     * @return
     */
    List<salarySetting> getSalaryList();
}

