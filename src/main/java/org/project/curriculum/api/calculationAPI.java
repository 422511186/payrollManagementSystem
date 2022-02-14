package org.project.curriculum.api;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.project.curriculum.api.Vo.AttendanceVO;
import org.project.curriculum.service.impl.calculationServiceImpl;
import org.project.curriculum.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: hzy
 * @Date: 2022/2/13 00:11
 * @Description:
 */
@Slf4j
@Api(tags = "工资计算考核")
@RestController
@RequestMapping(value = "/api/calculation")
public class calculationAPI {
    @Autowired
    private calculationServiceImpl calculationService;

    @GetMapping(value = "getAttendance")
    public  Result<List<AttendanceVO>> getAttendance(){
        List<AttendanceVO> attendanceVOList = calculationService.getAttendance();
        Result<List<AttendanceVO>> result = new Result<>(200, "success", attendanceVOList);
        return result;
    }

    @GetMapping(value = "getAttendanceByID")
    public Result getAttendanceByID(@RequestParam(value = "id") Integer id){
        List<AttendanceVO> attendanceByID = calculationService.getAttendanceByID(id);
        Result<List<AttendanceVO>> result = new Result<>(200, "success", attendanceByID);
        return result;
    }

    @GetMapping(value = "count")
    public Result count(@RequestParam(value = "id") Integer id,
                        @RequestParam(value = "time") String time){
        int value = calculationService.count(id,time);
        Result<Integer> result = new Result<>(200, "success", value);
        return result;
    }






}
