package org.project.curriculum.mapper;

import org.junit.jupiter.api.Test;
import org.project.curriculum.pojo.payroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: hzy
 * @Date: 2022/2/8 15:10
 * @Description:
 */
@SpringBootTest
@Transactional
class payrollMapperTest {

    @Autowired
    private payrollMapper mapper;

    @Test
    void select() {
        List<payroll> list = mapper.select(null);
        System.out.println("------------------------");
        list.forEach(System.out::println);
        System.out.println("------------------------");
        System.out.println("------------------------");

        payroll payroll = new payroll(15,0,"p2");
        List<payroll> list1 = mapper.select(payroll);
        System.out.println("------------------------");
        list1.forEach(System.out::println);
        System.out.println("------------------------");

    }

    @Test
    void insertOne() {
        payroll payroll = new payroll(null,10,"p2");
        int result = mapper.insertOne(payroll);
        System.out.println("------------------------");
        System.out.println(result);
        System.out.println("------------------------");
    }

    @Test
    void insertBatch() {
        payroll payroll = new payroll(null,9,"p2");
        payroll payroll1 = new payroll(null,10,"p2");
        ArrayList<payroll> list = new ArrayList<payroll>(){{
            add(payroll);
            add(payroll1);
        }};

        int result = mapper.insertBatch(list);
        System.out.println("------------------------");
        System.out.println(result);
        System.out.println("------------------------");
    }

    @Test
    void updateOne() {
        payroll payroll = new payroll(5,9,"p2");
        payroll payroll1 = new payroll(null,10,"p2");
        ArrayList<payroll> list = new ArrayList<payroll>(){{
            add(payroll);
            add(payroll1);
        }};

        int result = mapper.updateOne(payroll);
        System.out.println("------------------------");
        System.out.println(result);
        System.out.println("------------------------");
    }

    @Test
    void updateBatch() {
        payroll payroll = new payroll(5,9,"p2");
        payroll payroll1 = new payroll(15,10,"p2");
        ArrayList<payroll> list = new ArrayList<payroll>(){{
            add(payroll);
            add(payroll1);
        }};

        int result = mapper.updateBatch(list);
        System.out.println("------------------------");
        System.out.println(result);
        System.out.println("------------------------");
    }

    @Test
    void deleteOne() {
        payroll payroll = new payroll(45,null,null);

        int result = mapper.deleteOne(payroll);
        System.out.println("------------------------");
        System.out.println(result);
        System.out.println("------------------------");
    }

    @Test
    void deleteBatch() {

        ArrayList<payroll> list = new ArrayList<payroll>(){{
            add(new payroll(5,null,null));
            add(new payroll(15,null,null));
            add(new payroll(16,null,null));
        }};

        int result = mapper.deleteBatch(list);
        System.out.println("------------------------");
        System.out.println(result);
        System.out.println("------------------------");
    }
}