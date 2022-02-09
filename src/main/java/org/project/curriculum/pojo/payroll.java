package org.project.curriculum.pojo;

/**
 * 员工工资表
 *
 * @Auther: hzy
 * @Date: 2022/2/8 07:09
 * @Description:
 */

public class payroll {
    private Integer payrollId;
    private Integer employeeId;
    private String Position;

    public payroll() {
    }

    public payroll(Integer payrollId, Integer employeeId, String position) {
        this.payrollId = payrollId;
        this.employeeId = employeeId;
        Position = position;
    }

    public Integer getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(Integer payrollId) {
        this.payrollId = payrollId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    @Override
    public String toString() {
        return "payroll{" +
                "payrollId=" + payrollId +
                ", employeeId=" + employeeId +
                ", Position='" + Position + '\'' +
                '}';
    }
}
