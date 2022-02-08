package org.project.curriculum.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String test(){
        return "test";
    }
}
