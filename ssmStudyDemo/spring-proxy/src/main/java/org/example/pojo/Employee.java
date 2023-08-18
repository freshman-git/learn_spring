package org.example.pojo;

public class Employee {

    private static int id=1;
    private int age;

    public Employee(int age) {
        this.age = age;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Employee.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
