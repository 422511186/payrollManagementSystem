package org.project.curriculum.mapper;

import org.junit.jupiter.api.Test;
import org.project.curriculum.pojo.salarySetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


/**
 * @Auther: hzy
 * @Date: 2022/2/8 07:47
 * @Description:
 */
@SpringBootTest
class salarySettingMapperTest {

    @Autowired
    private salarySettingMapper mapper;

    @Test
    void insertBatch() {
        List<salarySetting> salarySettings = new ArrayList<>();
        salarySetting bean = new salarySetting("p10",222);
        salarySetting bean1 = new salarySetting("p11",222);
        salarySetting bean2 = new salarySetting("p12",222);

        salarySettings.add(bean);
        salarySettings.add(bean1);
        salarySettings.add(bean2);

        System.out.println(mapper.insertBatch(salarySettings));
    }
     @Test
    void insertOne() {
        salarySetting bean = new salarySetting("p13",222);
         System.out.println(mapper.insertOne(bean));
     }

    @Test
    void selectAll() {
        List<salarySetting> salarySettings = mapper.selectAll();
        salarySettings.forEach(System.out::println);
    }


    @Test
    void updateOne() {
        List<salarySetting> salarySettings = new ArrayList<>();
        salarySetting bean = new salarySetting("p101",333);
        salarySetting bean1 = new salarySetting("p11",222);
        salarySetting bean2 = new salarySetting("p12",222);

        salarySettings.add(bean);
        salarySettings.add(bean1);
        salarySettings.add(bean2);
        System.out.println(mapper.updateOne(bean));
    }

    @Test
    void updateBatch() {
        List<salarySetting> salarySettings = new ArrayList<>();
        salarySetting bean = new salarySetting("p10",33);
        salarySetting bean1 = new salarySetting("p11",23322);
        salarySetting bean2 = new salarySetting("p12",2232);

        salarySettings.add(bean);
        salarySettings.add(bean1);
        salarySettings.add(bean2);
        System.out.println(mapper.updateBatch(salarySettings));
    }

    @Test
    void deleteOne() {
        List<salarySetting> salarySettings = new ArrayList<>();
        salarySetting bean = new salarySetting("p10",33);
        salarySetting bean1 = new salarySetting("p11",23322);
        salarySetting bean2 = new salarySetting("p12",2232);
        salarySetting bean3 = new salarySetting("p13",222);

        salarySettings.add(bean);
        salarySettings.add(bean1);
        salarySettings.add(bean2);
        System.out.println(mapper.deleteOne(bean3));
    }

    @Test
    void deleteBatch() {
        List<salarySetting> salarySettings = new ArrayList<>();
        salarySetting bean = new salarySetting("p10",33);
        salarySetting bean1 = new salarySetting("p11",23322);
        salarySetting bean2 = new salarySetting("p12",2232);

        salarySettings.add(bean);
        salarySettings.add(bean1);
        salarySettings.add(bean2);
        System.out.println(mapper.deleteBatch(salarySettings));
    }
}