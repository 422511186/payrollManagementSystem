package org.project.curriculum.service.impl;

import org.project.curriculum.api.Params.employeeInfoParam;
import org.project.curriculum.api.Params.modifyParam;
import org.project.curriculum.api.Params.resignParam;
import org.project.curriculum.api.Vo.employeeInfoVO;
import org.project.curriculum.exception.FailException;
import org.project.curriculum.mapper.employeeInformationMapper;
import org.project.curriculum.mapper.payrollMapper;
import org.project.curriculum.pojo.employeeInformation;
import org.project.curriculum.pojo.payroll;
import org.project.curriculum.service.employeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @Auther: hzy
 * @Date: 2022/2/8 23:31
 * @Description:
 */

@Service
@Transactional(rollbackFor = {FailException.class, SQLException.class})
public class employeeServiceImpl implements employeeService {

    private final employeeInformationMapper employeeInformationMapper;
    private final payrollMapper payrollMapper;

    public employeeServiceImpl(employeeInformationMapper employeeInformationMapper, payrollMapper payrollMapper) {
        this.employeeInformationMapper = employeeInformationMapper;
        this.payrollMapper = payrollMapper;
    }

    /**
     * 获取员工信息列表
     *
     * @return
     */
    @Override
    public List<employeeInfoVO> getEmployeeList() {
        List<employeeInfoVO> employeeInfoVos = employeeInformationMapper.selectVO();
        return employeeInfoVos;
    }

    /**
     * 员工入职
     *
     * @return
     */
    @Override
    public int addEmployeeInfo(employeeInfoParam obj) throws FailException {
        employeeInformation information = new employeeInformation();
        information.setName(obj.getName());
        information.setEntry_time(new Date());
        int result = employeeInformationMapper.insertOne(information);
        if (result == 0)
            throw new FailException("操作失败，请重新操作");

        System.out.println("information.getId() = " + information.getId());

        payroll payroll = new payroll();
        payroll.setEmployeeId(information.getId());
        payroll.setPosition(obj.getPosition());

        int i = payrollMapper.insertOne(payroll);
        if (i == 0)
            throw new FailException("操作失败，请重新操作");
        return 1;
    }

    /**
     * 员工离职
     *
     * @param param
     * @return
     */
    @Override
    public int resign(resignParam param) throws FailException {
        int one
                = payrollMapper.deleteOne(new payroll(0,
                param.getId(),
                null));

        int one1
                = employeeInformationMapper.deleteOne(new employeeInformation(param.getId(),
                param.getName(),
                null));
        if (one == 0 || one1 == 0)
            throw new FailException("操作失败，请重新操作");
        return 1;
    }

    /**
     * 修改员工信息
     *
     * @param param
     * @return
     */
    @Override
    public int modify(modifyParam param) throws FailException {

        int one = employeeInformationMapper.updateOne(new employeeInformation(param.getId(),
                param.getName(),
                null));
        int one1 = payrollMapper.updateOne(new payroll(0,
                param.getId(),
                param.getPosition()));

        if (one == 0 || one1 == 0)
            throw new FailException("操作失败，请重新操作");
        return 1;
    }

    /**
     * 关键词模糊查询员工信息
     * @param value
     * @return
     */
    @Override
    public List<employeeInfoVO> selectLike(String value) {
        return  employeeInformationMapper.selectLike(value);
    }

    @Override
    public int count() {
        return employeeInformationMapper.count();
    }
}
