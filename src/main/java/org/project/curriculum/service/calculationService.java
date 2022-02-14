package org.project.curriculum.service;

import org.project.curriculum.api.Vo.AttendanceVO;

import java.util.List;

/**
 * @Auther: hzy
 * @Date: 2022/2/13 01:21
 * @Description:
 */
public interface calculationService {
    /**
     * 获取全部考核表
     * @return
     */
    List<AttendanceVO> getAttendance();

    /**
     * 获取某个员工的考核信息表
     * @param id    员工id
     * @param
     * @return
     */
    List<AttendanceVO> getAttendanceByID(int id);

    /**
     * 获取某个员工在某月的到勤次数
     * @param id
     * @param time YYYY-MM-DD
     * @return
     */
    int count(int id,String time);




}
