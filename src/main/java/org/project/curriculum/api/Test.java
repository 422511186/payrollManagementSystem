package org.project.curriculum.api;

import org.project.curriculum.exception.FailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口类
 *
 * @Auther: hzy
 * @Date: 2022/2/8 06:34
 * @Description:
 */

@RestController
public class Test {
    @GetMapping(value = "/test")
    public String test() throws Exception {
        throw new FailException("111");
    }
    @PostMapping(value = "/test1")
    public String test1() throws Exception {
        throw new FailException("111");
    }


}
