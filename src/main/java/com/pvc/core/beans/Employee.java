package com.pvc.core.beans;

import java.util.Date;

public class Employee implements Comparable< Employee > {
    private Integer empId;
    private String empName;
    private Date doj;

    public Employee(Integer empId, String empName, Date doj) {
        this.empId = empId;
        this.empName = empName;
        this.doj = doj;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", doj=" + doj +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.getEmpId().compareTo(o.getEmpId());    }
}
