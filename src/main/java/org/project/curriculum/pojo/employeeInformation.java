package org.project.curriculum.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 员工信息表
 * @Auther: hzy
 * @Date: 2022/2/8 06:48
 * @Description:
 */
public class employeeInformation {
    private Integer id;
    private String name;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date entryTime;

    public employeeInformation() {
    }

    public employeeInformation(Integer id, String name, Date entryTime) {
        this.id = id;
        this.name = name;
        this.entryTime = entryTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEntry_time() {
        return entryTime;
    }

    public void setEntry_time(Date entry_time) {
        this.entryTime = entry_time;
    }

    @Override
    public String toString() {
        return "employeeInformation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", entry_time='" + entryTime + '\'' +
                '}';
    }
}
