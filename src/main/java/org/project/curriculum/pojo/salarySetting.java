package org.project.curriculum.pojo;

/**
 * @Auther: hzy
 * @Date: 2022/2/8 06:43
 * @Description:
 */

public class salarySetting {
    private String Position;
    private Double salary;

    public salarySetting() {
    }

    public salarySetting(String Position, double salary) {
        this.Position = Position;
        this.salary = salary;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "salary_setting{" +
                "Position='" + Position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
