package org.project.curriculum.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.project.curriculum.api.params.employeeInfoParam;
import org.project.curriculum.api.params.modifyParam;
import org.project.curriculum.api.params.resignParam;
import org.project.curriculum.api.vo.employeeInfoOv;
import org.project.curriculum.exception.FailException;
import org.project.curriculum.service.impl.employeeServiceImpl;
import org.project.curriculum.utils.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: hzy
 * @Date: 2022/2/9 13:46
 * @Description:
 */

@RestController
@RequestMapping("/employee")
@Api(tags = "员工信息接口")
public class employeeController {

    private final employeeServiceImpl employeeService;

    public employeeController(employeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @ApiOperation("获取员工信息列表")
    @GetMapping(value = "getList")
    public Result<List<employeeInfoOv>> getList() {
        List<employeeInfoOv> list = employeeService.getEmployeeList();
        return new Result<>(200, "success", list);
    }

    @ApiOperation("新增员工")
    @PostMapping(value = "addInfo")
    public Result addInfo(@RequestBody employeeInfoParam param) throws FailException {
        employeeService.addEmployeeInfo(param);
        return new Result<>(200, "success", "添加员工完成。");
    }

    @ApiOperation("删除员工-员工离职")
    @PostMapping(value = "resign")
    public Result resign(@RequestBody resignParam param) throws FailException {
        employeeService.resign(param);
        return new Result<>(200, "success", "已成功为该员工办理离职。");
    }

    @ApiOperation("修改员工信息")
    @PostMapping(value = "modify")
    public Result modify(@RequestBody modifyParam param) throws FailException {
        employeeService.modify(param);
        return new Result<>(200, "success", "修改员工信息完成。");
    }

}
