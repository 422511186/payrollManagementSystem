package org.project.curriculum.mapper;

import org.junit.jupiter.api.Test;
import org.project.curriculum.pojo.employeeInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: hzy
 * @Date: 2022/2/8 15:10
 * @Description:
 */

@SpringBootTest
@Transactional
class employeeInformationMapperTest {
    @Autowired
    private employeeInformationMapper mapper;
    @Test
    void selectAll() {
        employeeInformation employeeInformation = new employeeInformation(1,null,null);
        List<employeeInformation> list = mapper.selectAll(employeeInformation);
        System.out.println("------------------------");
        list.forEach(System.out::println);
        System.out.println("------------------------");
    }

    @Test
    void insertOne() {
        employeeInformation employeeInformation = new employeeInformation(null,"hzy",new Date());
        int result = mapper.insertOne(employeeInformation);
        System.out.println("------------------------");
        System.out.println(result);
        System.out.println("employeeInformation.getId() = " + employeeInformation.getId());
        System.out.println("------------------------");
    }

    @Test
    void insertBatch() {
        employeeInformation employeeInformation = new employeeInformation(null,"hzy",new Date());
        employeeInformation employeeInformation1 = new employeeInformation(null,"hzy1",new Date());
        employeeInformation employeeInformation2 = new employeeInformation(null,"hzy2",new Date());
        ArrayList<org.project.curriculum.pojo.employeeInformation> list = new ArrayList<employeeInformation>() {{
            add(employeeInformation);
            add(employeeInformation1);
            add(employeeInformation2);
        }};
        int result = mapper.insertBatch(list);
        System.out.println("------------------------");
        System.out.println(result);
        list.forEach(e->{
            System.out.println("e.getId() = " + e.getId());
        });
        System.out.println("------------------------");
    }

    @Test
    void updateOne() {
        employeeInformation employeeInformation = new employeeInformation(1,"hzy11",null);
        int result = mapper.updateOne(employeeInformation);
        System.out.println("------------------------");
        System.out.println("result = " + result);
        System.out.println("------------------------");
    }

    @Test
    void updateBatch() {
        employeeInformation employeeInformation = new employeeInformation(1,"hzy",new Date());
        employeeInformation employeeInformation1 = new employeeInformation(2,"hzy1",new Date());
        employeeInformation employeeInformation2 = new employeeInformation(3,"hzy2",new Date());
        ArrayList<org.project.curriculum.pojo.employeeInformation> list = new ArrayList<employeeInformation>() {{
            add(employeeInformation);
            add(employeeInformation1);
            add(employeeInformation2);
        }};
        int result = mapper.updateBatch(list);
        System.out.println("------------------------");
        System.out.println(result);
        System.out.println("------------------------");
    }

    @Test
    void deleteOne() {
        employeeInformation employeeInformation = new employeeInformation(1,"hzy11",null);
        int result = mapper.deleteOne(employeeInformation);
        System.out.println("------------------------");
        System.out.println("result = " + result);
        System.out.println("------------------------");
    }

    @Test
    void deleteBatch() {
        employeeInformation employeeInformation = new employeeInformation(1,"hzy",new Date());
        employeeInformation employeeInformation1 = new employeeInformation(2,"hzy1",new Date());
        employeeInformation employeeInformation2 = new employeeInformation(3,"hzy2",new Date());
        ArrayList<org.project.curriculum.pojo.employeeInformation> list
                = new ArrayList<employeeInformation>() {{
            add(employeeInformation);
            add(employeeInformation1);
            add(employeeInformation2);
        }};
        int result = mapper.deleteBatch(list);
        System.out.println("------------------------");
        System.out.println(result);
        System.out.println("------------------------");
    }
}