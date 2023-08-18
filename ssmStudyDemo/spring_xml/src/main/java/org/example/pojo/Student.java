package org.example.pojo;

import java.util.Arrays;
import java.util.Map;

public class Student {
    private String name;
    private int age;
    private Clazz clazz;
    private String[] hobby;
    private Money[] moneys;
    private Map<String,Teacher> map;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", clazz=" + clazz +
                ", hobby=" + Arrays.toString(hobby) +
                ", moneys=" + Arrays.toString(moneys) +
                ", map=" + map +
                '}';
    }

    public Map<String, Teacher> getMap() {
        return map;
    }

    public void setMap(Map<String, Teacher> map) {
        this.map = map;
    }

    public Money[] getMoneys() {
        return moneys;
    }

    public void setMoneys(Money[] moneys) {
        this.moneys = moneys;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

}
