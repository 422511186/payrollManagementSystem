package org.project.curriculum.mapper;

import org.apache.ibatis.annotations.Param;
import org.project.curriculum.pojo.salarySetting;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: hzy
 * @Date: 2022/2/8 07:15
 * @Description:
 */
@Repository
public interface salarySettingMapper {

    /**
     * 获取企业工资表
     *
     * @return
     */
    List<salarySetting> selectAll();

    /**
     * 单条插入
     *
     * @param value
     */
    int insertOne(@Param("value") salarySetting value);

    /**
     * 批量插入
     *
     * @param list
     */
    int insertBatch(@Param("list") List<salarySetting> list);

    /**
     * 修改单个
     *
     * @param value
     * @return
     */
    int updateOne(@Param("value") salarySetting value);

    /**
     * 批量修改
     *
     * @param list
     * @return
     */
    int updateBatch(@Param("list") List<salarySetting> list);

    /**
     * 删除单个
     *
     * @param value
     * @return
     */
    int deleteOne(@Param("value") salarySetting value);

    /**
     * 批量删除
     *
     * @param list
     * @return
     */
    int deleteBatch(@Param("list") List<salarySetting> list);

}
