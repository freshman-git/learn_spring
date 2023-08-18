package org.example.pojo;

public class User {

    private int id;
    private String userName;
    private String password;
    private int age;

    public User() {
        System.out.println("生命周期1：实例化");
    }

    public User(int id, String userName, String password, int age) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("生命周期2：依赖注入");
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void initMethod(){
        System.out.println("生命周期3：初始化方法");
    }

    public void destroyMethod(){
        System.out.println("生命周期4：销毁方法");
    }
}
