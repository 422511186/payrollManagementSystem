package org.project.curriculum.api;

import io.swagger.annotations.Api;
import org.project.curriculum.exception.FailException;
import org.project.curriculum.pojo.salarySetting;
import org.project.curriculum.service.impl.basicSalaryServiceImpl;
import org.project.curriculum.utils.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @Auther: hzy
 * @Date: 2022/2/8 19:26
 * @Description:
 */

@RestController
@RequestMapping(value = "/Salary")
@Api(tags = "企业工资设定接口")
public class basicSalaryController {
    private final basicSalaryServiceImpl basicSalaryService;

    /**
     * 通过构造函数，从spring容器中进行依赖注入
     *
     * @param basicSalaryService
     */
    public basicSalaryController(basicSalaryServiceImpl basicSalaryService) {
        this.basicSalaryService = basicSalaryService;
    }

    /**
     * 获取列表
     *
     * @return
     * @throws FailException
     */
    @GetMapping("/getSalaryList")
    Result<List<salarySetting>> getSalaryList() throws FailException {
        List<salarySetting> list = basicSalaryService.getSalaryList();
        Result<List<salarySetting>> result = new Result<>(200, "success", list);
        return result;
    }

    /**
     * 批量插入
     *
     * @param list
     * @return
     * @throws FailException
     */
    @PostMapping("/initList")
    Result<String> setSalaryList(@RequestBody salarySetting[] list) throws FailException {
        basicSalaryService.InitBasicSalary(Arrays.asList(list));
        Result<String> result = new Result<>(200, "success", "初始化成功");
        return result;
    }

    /**
     * 添加一个
     *
     * @param list
     * @return
     * @throws FailException
     */
    @PostMapping("/addOneItem")
    Result<String> addOneItem(@RequestBody salarySetting list) throws FailException {
        basicSalaryService.addOneItem(list);
        Result<String> result = new Result<>(200, "success", "添加成功");
        return result;
    }

    /**
     * 批量修改
     *
     * @param list
     * @return
     * @throws FailException
     */
    @PostMapping("/updateBasicSalary")
    Result<String> updateBasicSalary(@RequestBody salarySetting[] list) throws FailException {
        basicSalaryService.updateBasicSalary(Arrays.asList(list));
        Result<String> result = new Result<>(200, "success", "修改成功");
        return result;
    }

    /**
     * 批量删除
     *
     * @param list
     * @return
     * @throws FailException
     */
    @PostMapping("/deleteByObj")
    Result<String> deleteByObj(@RequestBody salarySetting[] list) throws FailException {
        basicSalaryService.deleteByObj(Arrays.asList(list));
        Result<String> result = new Result<>(200, "success", "删除成功");
        return result;
    }

}
