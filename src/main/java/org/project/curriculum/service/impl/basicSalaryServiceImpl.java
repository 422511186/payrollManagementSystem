package org.project.curriculum.service.impl;

import org.project.curriculum.api.Vo.salarySettingVO;
import org.project.curriculum.exception.FailException;
import org.project.curriculum.mapper.salarySettingMapper;
import org.project.curriculum.pojo.salarySetting;
import org.project.curriculum.service.basicSalaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: hzy
 * @Date: 2022/2/8 19:08
 * @Description:
 */
@Service
@Transactional(rollbackFor = {FailException.class, SQLException.class})
public class basicSalaryServiceImpl implements basicSalaryService {

    private final salarySettingMapper salarySettingMapper;

    public basicSalaryServiceImpl(salarySettingMapper salarySettingMapper) {
        this.salarySettingMapper = salarySettingMapper;
    }

    /**
     * 初始化工资报表业务(批量插入操作)
     *
     * @param list
     * @return
     */
    @Override
    public int InitBasicSalary(List<salarySetting> list) throws FailException {
        int result = salarySettingMapper.insertBatch(list);
        if (result == 0)
            throw new FailException("操作失败，请重新操作");
        return result;
    }

    /**
     * 添加一条信息
     *
     * @param value
     * @return
     */
    @Override
    public int addOneItem(salarySetting value) throws FailException {
        int result = salarySettingMapper.insertOne(value);
        if (result == 0)
            throw new FailException("操作失败，请重新操作");
        return result;
    }

    /**
     * 批量更新‘职称’相对应的基本工资
     *
     * @param list
     * @return
     */
    @Override
    public int updateBasicSalary(List<salarySetting> list) throws FailException {
        int result = salarySettingMapper.updateBatch(list);
        if (result == 0)
            throw new FailException("操作失败，请重新操作");
        return result;
    }

    /**
     * 单个更新’职称‘相对应的基本工资
     *
     * @param value
     * @return
     */
    @Override
    public int updateBasicSalary(salarySetting value) throws FailException {
        int result = salarySettingMapper.updateOne(value);
        if (result == 0)
            throw new FailException("操作失败，请重新操作");
        return result;
    }

    /**
     * 删除单条
     *
     * @param value
     * @return
     */
    @Override
    public int deleteByObj(salarySetting value) throws FailException {
        int result = salarySettingMapper.deleteOne(value);
        if (result == 0)
            throw new FailException("删除失败，请重新尝试");
        return result;
    }

    /**
     * 删除多条
     *
     * @param list
     * @return
     */
    @Override
    public int deleteByObj(List<salarySetting> list) throws FailException {
        int result = salarySettingMapper.deleteBatch(list);
        if (result == 0)
            throw new FailException("操作失败，请重新操作");
        return result;
    }

    /**
     * 获取企业基本工资列表
     *
     * @return
     */
    @Override
    public List<salarySettingVO> getSalaryList() {
        return salarySettingMapper.selectAll();
    }

    @Override
    public List<salarySettingVO> getPositionCount() {
        return salarySettingMapper.getPositionCount();
    }
}
