package org.project.curriculum.service.impl;

import org.project.curriculum.api.Vo.AttendanceVO;
import org.project.curriculum.mapper.timeSheetMapper;
import org.project.curriculum.service.calculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: hzy
 * @Date: 2022/2/13 01:21
 * @Description:
 */

@Service
public class calculationServiceImpl implements calculationService {
    @Autowired
    private timeSheetMapper timeSheetMapper;


    /**
     * 获取全部考核表
     *
     * @return
     */
    @Override
    public List<AttendanceVO> getAttendance() {
        return timeSheetMapper.select();
    }

    /**
     * 获取某个员工的考核信息表
     *
     * @param id 员工id
     * @return
     */
    @Override
    public List<AttendanceVO> getAttendanceByID(int id) {
        return timeSheetMapper.selectById(id);
    }

    /**
     * 获取某个员工在某月的到勤次数
     *
     * @param id
     * @return
     */
    @Override
    public int count(int id,String time) {
        return timeSheetMapper.count(id,time);
    }
}
