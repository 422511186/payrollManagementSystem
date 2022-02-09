package org.project.curriculum.mapper;

import org.junit.jupiter.api.Test;
import org.project.curriculum.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther: hzy
 * @Date: 2022/2/10 00:53
 * @Description:
 */
@SpringBootTest
//@Transactional
class userMapperTest {
    @Autowired
    private userMapper mapper;

    @Test
    void selectByAccount() {
        user result = mapper.selectByAccount("hzy1");
        System.out.println("result = " + result);
    }

    @Test
    void insert() {
        int result = mapper.insert(new user(0, "hzy", "hzy"));
        System.out.println("result = " + result);
    }

    @Test
    void updatePwsByAccount() {
        int result = mapper.updatePwsByAccount(new user(0, "hzy", "11111"));
        System.out.println("result = " + result);
    }
}