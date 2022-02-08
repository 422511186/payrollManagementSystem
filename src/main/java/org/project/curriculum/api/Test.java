package org.project.curriculum.api;

import org.project.curriculum.exception.FailException;
import org.project.curriculum.pojo.salarySetting;
import org.project.curriculum.utils.Result;
import org.springframework.web.bind.annotation.*;

/**
 * 测试接口类
 * @Auther: hzy
 * @Date: 2022/2/8 06:34
 * @Description:
 */

@RestController
@CrossOrigin
public class Test {
    @GetMapping(value = "/test")
    public String test() throws Exception{
        throw  new FailException("111");
    }


}
