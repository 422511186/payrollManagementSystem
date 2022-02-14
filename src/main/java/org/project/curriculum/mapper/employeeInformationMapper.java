package org.project.curriculum.mapper;

import org.apache.ibatis.annotations.Param;
import org.project.curriculum.api.Vo.employeeInfoVO;
import org.project.curriculum.pojo.employeeInformation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: hzy
 * @Date: 2022/2/8 07:15
 * @Description:
 */
@Repository
public interface employeeInformationMapper {

    /**
     * 获取员工信息表
     *
     * @return 员工信息列表
     */
    List<employeeInformation> selectAll(@Param("value") employeeInformation value);

    /**
     * 获取员工信息职位
     *
     * @return
     */
    List<employeeInfoVO> selectOV();


    /**
     * 单条插入
     *
     * @param value
     * @return 影响的行数
     */
    int insertOne(@Param("value") employeeInformation value);

    /**
     * 批量插入
     *
     * @param list
     * @return 影响的行数
     */
    int insertBatch(@Param("list") List<employeeInformation> list);

    /**
     * 修改单个
     *
     * @param value
     * @return 是否成功
     */
    int updateOne(@Param("value") employeeInformation value);

    /**
     * 批量修改
     *
     * @param list
     * @return 是否成功
     */
    int updateBatch(@Param("list") List<employeeInformation> list);

    /**
     * 删除单个
     *
     * @param value
     * @return 是否成功
     */
    int deleteOne(@Param("value") employeeInformation value);

    /**
     * 批量删除
     *
     * @param list
     * @return 是否成功
     */
    int deleteBatch(@Param("list") List<employeeInformation> list);
}
