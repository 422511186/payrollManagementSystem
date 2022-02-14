package org.project.curriculum.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Auther: hzy
 * @Date: 2022/2/12 23:46
 * @Description:
 */
public class timeSheet {
    private int id;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date dtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDtime() {
        return dtime;
    }

    public void setDtime(Date dtime) {
        this.dtime = dtime;
    }
}
