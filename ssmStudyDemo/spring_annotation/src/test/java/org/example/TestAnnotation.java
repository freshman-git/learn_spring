package org.example;

import org.example.controller.UserController;
import org.example.dao.UserDao;
import org.example.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {

    @Test
    public void TestAnnotation(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-annotation.xml");
//        UserController userController = context.getBean(UserController.class);
//        System.out.println(userController);
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService);
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao);
    }

    @Test
    public void TestAnnotation2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-annotation.xml");
        UserController userController = context.getBean(UserController.class);
        userController.saveUser();
    }
}
