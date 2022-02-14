package org.project.curriculum.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.project.curriculum.api.Vo.AttendanceVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: hzy
 * @Date: 2022/2/12 23:49
 * @Description:
 */
@Repository
public interface timeSheetMapper {

    @Select(
           value = "select count(*) " +
                   "from    time_sheet  " +
                   "where date_format(dtime,'%Y-%m')=#{time} " +
                   "and id=#{id};"
    )
    Integer count(@Param("id") int id, @Param("time") String time);

    @Select(
            value = "select e.id as id, e.name as name,t.dtime as dtime " +
                    "from time_sheet t " +
                    "left join employee_information e " +
                    "on t.id = e.id  " +
                    "where t.id=#{id} "+
                    "order by dtime desc , id asc"
    )
    List<AttendanceVO> selectById(@Param("id") int id);


    @Select(
            value ="select e.id as id,e.name as name,t.dtime as dtime " +
                    "from time_sheet t " +
                    "left join employee_information e " +
                    "on t.id = e.id " +
                    "order by dtime desc , id asc"
    )
    List<AttendanceVO> select();
}
