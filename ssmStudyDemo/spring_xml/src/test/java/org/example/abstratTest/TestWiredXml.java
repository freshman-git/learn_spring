package org.example.abstratTest;

import org.example.controller.UserController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestWiredXml {

    @Test
    public void testAutoWiredXml(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-autowired.xml");
        UserController userController = (UserController) context.getBean("userController");
        userController.saveUser();
    }
}
