package org.example.pojo;

public class Emp {

    private int empId;
    private String empName;
    private int age;
    private String gender;
    private int deptId;

    public Emp(int empId, String empName, int age, String gender, int deptId) {
        this.empId = empId;
        this.empName = empName;
        this.age = age;
        this.gender = gender;
        this.deptId = deptId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", deptId=" + deptId +
                '}';
    }


    public Emp() {
    }


    public Emp(int empId, String empName, int age, String gender) {
        this.empId = empId;
        this.empName = empName;
        this.age = age;
        this.gender = gender;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
