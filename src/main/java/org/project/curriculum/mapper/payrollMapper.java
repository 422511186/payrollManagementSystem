package org.project.curriculum.mapper;

import org.apache.ibatis.annotations.Param;
import org.project.curriculum.pojo.payroll;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: hzy
 * @Date: 2022/2/8 07:15
 * @Description:
 */
@Repository
public interface payrollMapper {
    /**
     * 获取员工工资表
     *
     * @return
     */
    List<payroll> select(@Param("value") payroll value);

    /**
     * 单条插入
     *
     * @param value
     */
    int insertOne(@Param("value") payroll value);

    /**
     * 批量插入
     *
     * @param list
     */
    int insertBatch(@Param("list") List<payroll> list);

    /**
     * 单个修改
     *
     * @param value
     * @return
     */
    int updateOne(@Param("value") payroll value);

    /**
     * 批量修改
     *
     * @param list
     * @return
     */
    int updateBatch(@Param("list") List<payroll> list);

    /**
     * 删除单个
     *
     * @param value
     * @return
     */
    int deleteOne(@Param("value") payroll value);

    /**
     * 批量删除
     *
     * @param list
     * @return
     */
    int deleteBatch(@Param("list") List<payroll> list);
}
