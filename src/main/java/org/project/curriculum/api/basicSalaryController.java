package org.project.curriculum.api;

import org.project.curriculum.exception.FailException;
import org.project.curriculum.pojo.salarySetting;
import org.project.curriculum.service.impl.basicSalaryServiceImpl;
import org.project.curriculum.utils.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 企业工资设定
 * @Auther: hzy
 * @Date: 2022/2/8 19:26
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/Salary")
public class basicSalaryController {
    private final basicSalaryServiceImpl basicSalaryService;

    public basicSalaryController(basicSalaryServiceImpl basicSalaryService) {
        this.basicSalaryService = basicSalaryService;
    }

    @GetMapping("/getSalaryList")
    Result<List<salarySetting>> getSalaryList() throws FailException {
        List<salarySetting> list = basicSalaryService.getSalaryList();
        Result<List<salarySetting>> result = new Result<>(200, "初始化成功",list);
        return result;

    }
    @PostMapping("/initList")
    Result<Integer> setSalaryList(@RequestBody salarySetting[] list) throws FailException {
        int value = basicSalaryService.InitBasicSalary(Arrays.asList(list));
        Result<Integer> result = new Result<>(200, "初始化成功",value);
        return result;
    }

    @PostMapping("/addOneItem")
    Result<Integer> addOneItem(@RequestBody salarySetting list) throws FailException {
        int value = basicSalaryService.addOneItem(list);
        Result<Integer> result = new Result<>(200, "添加成功",value);
        return result;
    }

    @PostMapping("/updateBasicSalary")
    Result<Integer> updateBasicSalary(@RequestBody salarySetting[] list) throws FailException {
        int value = basicSalaryService.updateBasicSalary(Arrays.asList(list));
        Result<Integer> result = new Result<Integer>(200, "修改成功",value);
        return result;
    }

   @PostMapping("/deleteByObj")
   Result<Integer> deleteByObj(@RequestBody salarySetting[] list) throws FailException {
       int value = basicSalaryService.deleteByObj(Arrays.asList(list));
       Result<Integer> result = new Result<>(200, "删除成功",value);
       return result;
   }

}
