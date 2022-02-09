package org.project.curriculum.service;

import org.project.curriculum.api.params.employeeInfoParam;
import org.project.curriculum.api.params.modifyParam;
import org.project.curriculum.api.params.resignParam;
import org.project.curriculum.api.vo.employeeInfoOv;
import org.project.curriculum.exception.FailException;

import java.util.List;

/**
 * 员工相关业务类
 *
 * @Auther: hzy
 * @Date: 2022/2/8 23:31
 * @Description:
 */
public interface employeeService {
    /**
     * 获取员工列表
     *
     * @return
     */
    List<employeeInfoOv> getEmployeeList();

    /**
     * 员工入职
     *
     * @return
     */
    int addEmployeeInfo(employeeInfoParam obj) throws FailException;

    /**
     * 员工离职
     *
     * @param param
     * @return
     */
    int resign(resignParam param) throws FailException;

    /**
     * 修改员工信息
     *
     * @param param
     * @return
     */
    int modify(modifyParam param) throws FailException;

}